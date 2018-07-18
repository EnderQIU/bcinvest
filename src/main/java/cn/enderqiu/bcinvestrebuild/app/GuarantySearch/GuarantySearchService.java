package cn.enderqiu.bcinvestrebuild.app.GuarantySearch;

import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.GuarantyVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by EvanChoo on 7/13/18.
 */

@Service
public class GuarantySearchService extends BaseService{
    static int ITEM_PER_PAGE = 20;

    public List<GuarantySearchVO> searchGuanranty(String user_id_token, int guarantyType, String guarantyName, int guarantyState) {
        String sql = getSQL(user_id_token, guarantyType, guarantyName, guarantyState);

        List<Map<String, Object>> list = mapper.SELECT(sql);

        List<GuarantySearchVO> voList = new ArrayList<>();

        for(Map<String, Object> item : list) {
            GuarantySearchVO searchVO = new GuarantySearchVO();
            //extract(searchVO, item);
            if(item.containsKey("GuarantyId"))
                searchVO.setGuarantyId((int)item.get("GuarantyId"));
            if(item.containsKey("ScopeOfRight"))
                searchVO.setScopeOfRight((int)item.get("ScopeOfRight"));
            if(item.containsKey("OwnerName"))
                searchVO.setOwnerName((String)item.get("OwnerName"));
            if(item.containsKey("EvaluateValue"))
                searchVO.setEvaluateValue((int)item.get("EvaluateValue"));
            if(item.containsKey("Name"))
                searchVO.setName((String)item.get("Name"));

            voList.add(searchVO);
        }

        return voList;
    }

    public MaxPageVO getMaxPage(String user_id_token, int guarantyType, String guarantyName, int guarantyState) {
        String sql = getSQL(user_id_token, guarantyType, guarantyName, guarantyState);

        sql = "SELECT COUNT(*) AS Number " +
              "FROM ("+sql+")a";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        long number = (long)list.get(0).get("Number");

        int maxPage = (int)Math.ceil((double)number/ITEM_PER_PAGE);

        MaxPageVO vo = new MaxPageVO();
        vo.setMaxPage(maxPage);

        return vo;
    }

    private String getSQL(String user_id_token, int guarantyType, String guarantyName, int guarantyState) {
        String whereClause = " WHERE AccountNum = \'"+token2AccountNum(user_id_token)+"\' ";

        if(guarantyType!=-1) {
            whereClause += " AND Type = "+guarantyType+" ";
        }

        if(guarantyName!=null) {
            whereClause += " AND Name LIKE \'%"+guarantyName+"%\' ";
        }

        if(guarantyState!=-1) {
            whereClause += " AND State = "+guarantyState+" ";
        }

        String sql = "SELECT GuarantyId, ScopeOfRight, OwnerName, EvaluateValue, Name " +
                "FROM Guaranty " +
                whereClause;

        return sql;
    }

    private String token2AccountNum(String user_id_token) {
        String sql = "SELECT AccountNum " +
                "FROM Company " +
                "WHERE Token = \'"+user_id_token+"\'";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        return list.get(0).get("AccountNum").toString();
    }
}
