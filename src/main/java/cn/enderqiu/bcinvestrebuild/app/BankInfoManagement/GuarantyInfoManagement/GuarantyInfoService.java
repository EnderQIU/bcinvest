package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.GuarantyInfoManagement;

import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.GuarantyInfoManagement.VO.GuarantyInfoDetailVO;
import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.GuarantyInfoManagement.VO.GuarantyInfoVO;
import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.GuarantyInfoManagement.VO.MaxPageVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import cn.enderqiu.bcinvestrebuild.mapper.Mapper;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.impls.BlockChainImpl;
import cn.ssyram.blockchain.impls.GurantyChainImpl;
import cn.ssyram.blockchain.interfaces.EvanGuarantyChainInterface;
import cn.ssyram.blockchain.interfaces.GuarantyChain;
import cn.ssyram.blockchain.samples.SampleGuarantyChainInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by EvanChoo on 7/15/18.
 */

@Service
public class GuarantyInfoService extends BaseService {
    static int ITEM_PER_PAGE = 20;

    public List<GuarantyInfoVO> getAllGuarantyInfo(int currentPage) {
        int startIndex = (currentPage-1)*ITEM_PER_PAGE;

        String sql = getSQL(startIndex);

        List<Map<String, Object>> list = mapper.SELECT(sql);

        List<GuarantyInfoVO> voList = new ArrayList<>();

        voList = autoFill(list);

        return voList;
    }

    public MaxPageVO getMaxPage() {
        String sql = getSQL(-1);

        List<Map<String, Object>> list = mapper.SELECT(sql);

        long number = (long)list.get(0).get("Number");

        int maxPage = (int)Math.ceil((double)number/ITEM_PER_PAGE);

        MaxPageVO vo = new MaxPageVO();
        vo.setMaxPage(maxPage);

        return vo;
    }

    public List<GuarantyInfoVO> getSearchResult(int guarantyType, String guarantyName, int guarantyState, int currentPage) {
        String whereClause = "WHERE 1=1 ";

        if(guarantyType!=-1) {
            whereClause = whereClause+"AND Type = "+guarantyType+" ";
        }
        if(guarantyName!=null) {
            whereClause = whereClause+"AND Name LIKE \'%"+guarantyName+"\' ";
        }
        if(guarantyState!=-1) {
            whereClause = whereClause+"AND State = "+guarantyState+" ";
        }

        int startIndex = (currentPage-1)*ITEM_PER_PAGE;

        String sql = "SELECT GuarantyId, ScopeOfRight, OwnerName, EvaluateValue, Name " +
                     "FROM Guaranty " +
                     whereClause+
                     "ORDER BY GuarantyId ASC " +
                     "LIMIT " + startIndex + ", " + ITEM_PER_PAGE;

        List<Map<String, Object>> list = mapper.SELECT(sql);
        List<GuarantyInfoVO> voList = new ArrayList<>();

        voList = autoFill(list);

        return voList;
    }

    public GuarantyInfoDetailVO getGuarantyDetail(int guarantyId) {
        String sql = "SELECT GuarantyId, State, ScopeOfRight, OwnerName, EvaluateValue, g.Name AS GuarantyName, c.Name AS CompanyName, g.AccountNum AS CompanyId, TelNum, EmailAddress " +
                     "FROM Guaranty g join Company c ON g.AccountNum = c.AccountNum " +
                     "WHERE GuarantyId = "+guarantyId+" ";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        if(list.isEmpty())
            return null;

        Map<String, Object> map = list.get(0);
        GuarantyInfoDetailVO vo = new GuarantyInfoDetailVO();

        vo.setGuarantyId((int)map.get("GuarantyId"));
        vo.setPropertyState((int)map.get("State"));
        vo.setScopeOfRight((int)map.get("ScopeOfRight"));
        vo.setOwnerName((String)map.get("OwnerName"));
        vo.setEvaluateValue((int)map.get("EvaluateValue"));
        vo.setName((String)map.get("GuarantyName"));
        vo.setCompanyName((String)map.get("CompanyName"));
        vo.setCompanyId((String)map.get("CompanyId"));
        vo.setCompanyTelNum((String)map.get("TelNum"));
        vo.setCompanyEmailAddress((String)map.get("EmailAddress"));

        return vo;
    }

    public BaseResponseVO forceOutChain(int guarantyId) {
        String sql = "DELETE FROM Guaranty " +
                     "WHERE GuarantyId = "+guarantyId+" ";

        int result = mapper.DELETE(sql);
        BaseResponseVO vo = new BaseResponseVO();

        if(result==1) {
            vo.setMessage("OK");
        } else {
            vo.setMessage("Error");
        }

        //todo: fix this
        //调用EvanGuarantyChainInterface中的deleteGuaranty

        return vo;
    }

    private String getSQL(int startIndex) {
        String sql;

        if(startIndex!=-1) {
            sql = "SELECT GuarantyId, ScopeOfRight, OwnerName, EvaluateValue, Name " +
                  "FROM Guaranty " +
                  "ORDER BY GuarantyId ASC " +
                  "LIMIT " + startIndex + ", " + ITEM_PER_PAGE;
        } else {
            sql = "SELECT GuarantyId, ScopeOfRight, OwnerName, EvaluateValue, Name " +
                  "FROM Guaranty " +
                  "ORDER BY GuarantyId ASC ";

            sql = "SELECT COUNT(*) AS Number " +
                  "FROM ("+sql+")a";
        }

        return sql;
    }

    private List<GuarantyInfoVO> autoFill(List<Map<String, Object>> list) {
        List<GuarantyInfoVO> voList = new ArrayList<>();

        for(Map<String, Object> item : list) {
            GuarantyInfoVO vo = new GuarantyInfoVO();

            vo.setGuarantyId((int)item.get("GuarantyId"));
            vo.setEvaluateValue((int)item.get("EvaluateValue"));
            vo.setName((String)item.get("Name"));
            vo.setOwnerName((String)item.get("OwnerName"));
            vo.setScopeOfRight((int)item.get("ScopeOfRight"));

            voList.add(vo);
        }

        return voList;
    }
}
