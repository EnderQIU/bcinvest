package cn.enderqiu.bcinvestrebuild.app.LoanManagement;

/**
 * Created by EvanChoo on 7/11/18.
 */

import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LoanService extends BaseService {
    static int ITEM_PER_PAGE = 20;
    static int onBCState = 4;
    static int applyingState = 5;

    public List<LoanVO> getLoanRequestedButNotPassed(String user_id_token, int pageIndex) {
        String AccountNum = token2AccountNum(user_id_token);

        int resultStartIndex = (pageIndex-1)*ITEM_PER_PAGE;


        String sql = "SELECT * " +
                     "FROM Guaranty " +
                     "WHERE AccountNum = \'"+AccountNum+"\' AND State = "+applyingState+" " +
                     "ORDER BY GuarantyId ASC " +
                     "LIMIT "+resultStartIndex+", 20";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        if(list.isEmpty())
            return null;

        List<LoanVO> result = new ArrayList<>();

        for(Map<String, Object> map : list) {
            LoanVO vo = new LoanVO();
            vo.setGuarantyId((int)map.get("GuarantyId"));
            vo.setScopeOfRight((int)map.get("ScopeOfRight"));
            vo.setOwnerName((String)map.get("OwnerName"));
            vo.setEvaluateValue((int)map.get("EvaluateValue"));
            vo.setName((String)map.get("Name"));
            //extract(vo, map);
            result.add(vo);
        }

        return result;
    }

    public MaxPageVO getMaxPage(String user_id_token) {
        String AccountNum = token2AccountNum(user_id_token);

        String sql = "SELECT * " +
                     "FROM Guaranty " +
                     "WHERE AccountNum = \'"+AccountNum+"\' AND State = "+applyingState+" ";

        sql = "SELECT COUNT(*) AS Number " +
              "FROM ("+sql+")a";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        long number = (long)list.get(0).get("Number");

        int maxPage = (int)Math.ceil((double)number/ITEM_PER_PAGE);

        MaxPageVO vo = new MaxPageVO();
        vo.setMaxPage(maxPage);

        return vo;
    }

    public LoanDetailVO getMortgageDetail(int guarantyId) {
        String sql = "SELECT GuarantyId, g.AccountNum AS CompanyAccount, State, ScopeOfRight, OwnerName, g.ReportId AS ReportId, g.Type AS GuarantyType, EvaluateValue, g.Name AS GuarantyName, r.AccountNum AS AuthAccount, Date, Duration, a.Name AS AuthName " +
                     "FROM Guaranty g join Report r on g.ReportId=r.ReportId join Authorization a on r.AccountNum=a.AccountNum " +
                     "WHERE g.GuarantyId="+guarantyId+" AND g.State = "+applyingState+" ";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        //如果sql执行失败，那么list为空，返回null；前端可以通过这个来判断失败
        if(list.isEmpty()) {
            return null;
        }

        LoanDetailVO vo = new LoanDetailVO();

        //extract(vo, list.get(0));

        Map<String, Object> map = list.get(0);

        vo.setGuarantyId((int)map.get("GuarantyId"));
        vo.setCompanyAccount((String)map.get("CompanyAccount"));
        vo.setState((int)map.get("State"));
        vo.setScopeOfRight((int)map.get("ScopeOfRight"));
        vo.setOwnerName((String)map.get("OwnerName"));
        vo.setReportId((int)map.get("ReportId"));
        vo.setGuarantyType(Integer.parseInt(map.get("GuarantyType").toString()));
        vo.setEvaluateValue((int)map.get("EvaluateValue"));
        vo.setGuarantyName((String)map.get("GuarantyName"));
        vo.setAuthAccount((String)map.get("AuthAccount"));
        vo.setDate(map.get("Date").toString());
        vo.setDuration((String)map.get("Duration"));
        vo.setAuthName((String)map.get("AuthName"));

        return vo;
    }

    public BaseResponseVO cancleLoanRequest(String user_id_token, int guarantyId) {
        String accountNum = token2AccountNum(user_id_token);

        String sql = "UPDATE Guaranty " +
                     "SET State = "+onBCState+" "+
                     "WHERE GuarantyId = "+guarantyId+" AND State = "+applyingState+" AND AccountNum = \'"+accountNum+"\'";

        int affectedRows = mapper.UPDATE(sql);

        BaseResponseVO vo = new BaseResponseVO();

        if(affectedRows==1){
            vo.setMessage("OK");
        } else {
            vo.setMessage("Error");
        }

        return vo;
    }

    private String token2AccountNum(String user_id_token) {
        String sql = "SELECT AccountNum " +
                     "FROM Company " +
                     "WHERE Token = \'"+user_id_token+"\'";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        return list.get(0).get("AccountNum").toString();
    }
}
