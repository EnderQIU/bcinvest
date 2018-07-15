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

    public List<GuarantySearchVO> searchGuanranty(String user_id_token, String guarantyType, String guarantyName, int guarantyState) {
        String sql = getSQL(user_id_token, guarantyType, guarantyName, guarantyState);

        List<Map<String, Object>> list = mapper.SELECT(sql);

        List<GuarantySearchVO> voList = new ArrayList<>();

        for(Map<String, Object> item : list) {
            GuarantySearchVO searchVO = new GuarantySearchVO();
            //extract(searchVO, item);
            searchVO.setGuarantyId((int)item.get("GuarantyId"));
            searchVO.setScopeOfRight((int)item.get("ScopeOfRight"));
            searchVO.setOwnerName((String)item.get("OwnerName"));
            searchVO.setEvaluateValue((int)item.get("EvaluateValue"));
            searchVO.setName((String)item.get("Name"));
            voList.add(searchVO);
        }

        return voList;
    }

    public MaxPageVO getMaxPage(String user_id_token, String guarantyType, String guarantyName, int guarantyState) {
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

    private String getSQL(String user_id_token, String guarantyType, String guarantyName, int guarantyState) {
        String whereClause = " WHERE AccountNum = \'"+token2AccountNum(user_id_token)+"\' ";

        //!!!: attention: 由于type在数据库中使用的是varchar，所以前台发送的时候一定要首字母大写
        if(guarantyType!=null) {
            whereClause += " AND Type = \'"+guarantyType+"\' ";
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
