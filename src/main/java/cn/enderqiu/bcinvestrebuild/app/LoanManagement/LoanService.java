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
public class LoanService extends BaseService
{
    public List<LoanVO> getLoanRequestedButNotPassed(String user_id_token, int pageIndex) {
        String AccountNum = token2AccountNum(user_id_token);

        int resultStartIndex = (pageIndex-1)*20;


        String sql = "SELECT * " +
                     "FROM Guaranty " +
                     "WHERE AccountNum = \'"+AccountNum+"\' AND State = 4 " +
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

    public LoanDetailVO getMortgageDetail(int guarantyId) {
        String sql = "SELECT GuarantyId, g.AccountNum AS CompanyAccount, State, ScopeOfRight, OwnerName, g.ReportId AS ReportId, g.Type AS GuarantyType, EvaluateValue, g.Name AS GuarantyName, r.AccountNum AS AuthAccount, Date, Duration, a.Name AS AuthName " +
                     "FROM Guaranty g join Report r on g.ReportId=r.ReportId join Authorization a on r.AccountNum=a.AccountNum " +
                     "WHERE g.GuarantyId="+guarantyId+" AND g.State=4";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        //如果sql执行失败，那么list为空，返回null；前端可以通过这个来判断失败
        if(list.isEmpty()) {
            return null;
        }

        LoanDetailVO vo = new LoanDetailVO();

        extract(vo, list.get(0));

        return vo;
    }

    public BaseResponseVO cancleLoanRequest(String user_id_token, int guarantyId) {
        //todo: implement this
        return null;
    }

    private String token2AccountNum(String user_id_token) {
        String sql = "SELECT AccountNum" +
                     "FROM Company" +
                     "WHERE Token = \'"+user_id_token+"\'";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        return list.get(0).get("AccountNum").toString();
    }
}
