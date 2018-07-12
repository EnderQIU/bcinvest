package cn.enderqiu.bcinvestrebuild.app.LoanManagement;

/**
 * Created by EvanChoo on 7/11/18.
 */

import cn.enderqiu.bcinvestrebuild.app.LoanManagement.LoanVO;
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
                     "WHERE AccountNum = "+AccountNum+" AND State = 4 " +
                     "ORDER BY GuarantyId ASC " +
                     "LIMIT "+resultStartIndex+", 20";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        List<LoanVO> result = new ArrayList<>();

        for(Map<String, Object> map : list) {
            LoanVO vo = new LoanVO();
            /*vo.setGuarantyId((int)map.get("GuarantyId"));
            vo.setScopeOfRight((int)map.get("ScopeOfRight"));
            vo.setOwnerName((String)map.get("OwnerName"));
            vo.setEvaluateValue((int)map.get("EvaluateValue"));
            vo.setName((String)map.get("Name"));*/
            extract(vo, map);
            result.add(vo);
        }

        return result;
    }

    public LoanVO getMortgageDetail(int guarantyId) {
        String sql = "SELECT * " +
                "FROM Guaranty g join " +
                "WHERE Account ";
        return null;
    }

    private String token2AccountNum(String user_id_token) {
        String sql = "SELECT AccountNum" +
                     "FROM Company" +
                     "WHERE Token = "+user_id_token;

        List<Map<String, Object>> list = mapper.SELECT(sql);

        return list.get(0).get("AccountNum").toString();
    }
}
