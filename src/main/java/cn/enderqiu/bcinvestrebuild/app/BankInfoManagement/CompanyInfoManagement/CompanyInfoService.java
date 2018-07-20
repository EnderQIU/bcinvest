package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement;

import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO.*;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import cn.enderqiu.bcinvestrebuild.mapper.Mapper;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.interfaces.EvanGuarantyChainInterface;
//import com.sun.tools.corba.se.idl.StringGen;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by EvanChoo on 7/14/18.
 */

@Service
public class CompanyInfoService extends BaseService {
    static int ITEM_PER_PAGE = 20;

    public List<CompanyInfoVO> getAllCompanyInfo(int currentPage) {
        int startIndex = (currentPage-1)*ITEM_PER_PAGE;

        String sql = "SELECT AccountNum, Name, TelNum, EmailAddress " +
                     "FROM Company " +
                     "LIMIT "+startIndex+", "+ITEM_PER_PAGE;

        List<Map<String, Object>> list = mapper.SELECT(sql);

        List<CompanyInfoVO> voList = new ArrayList<>();

        for(Map<String, Object> item : list) {
            CompanyInfoVO vo = new CompanyInfoVO();

            if(item.containsKey("AccountNum"))
                vo.setAccountNum((String) item.get("AccountNum"));

            if(item.containsKey("Name"))
                vo.setName((String)item.get("Name"));

            if(item.containsKey("TelNum"))
                vo.setTelNum((String)item.get("TelNum"));

            if(item.containsKey("EmailAddress"))
                vo.setEmailAddress((String)item.get("EmailAddress"));

            voList.add(vo);
        }

        return voList;
    }

    public MaxPageVO getMaxPage() {
        String sql = "SELECT COUNT(*) AS Number " +
                     "FROM Company";

        long number = (long)mapper.SELECT(sql).get(0).get("Number");

        int maxPage = (int)Math.ceil((double)number/ITEM_PER_PAGE);

        MaxPageVO vo = new MaxPageVO();
        vo.setMaxPage(maxPage);

        return vo;
    }

    public List<CompanyInfoVO> getSearchCompanyResult(String accountNum, String name, String telNum, String email, int currentPage) {
        String whereClause = getSQLClause(accountNum, name, telNum, email);

        int startIndex = (currentPage-1)*ITEM_PER_PAGE;

        String sql = "SELECT AccountNum, Name, TelNum, EmailAddress " +
                     "FROM Company " + whereClause +
                     "LIMIT "+startIndex+", "+ITEM_PER_PAGE;

        List<Map<String, Object>> list = mapper.SELECT(sql);
        List<CompanyInfoVO> voList = new ArrayList<>();

        for(Map<String, Object> item : list) {
            CompanyInfoVO vo = new CompanyInfoVO();

            if(item.containsKey("AccountNum"))
                vo.setAccountNum((String) item.get("AccountNum"));

            if(item.containsKey("Name"))
                vo.setName((String)item.get("Name"));

            if(item.containsKey("TelNum"))
                vo.setTelNum((String)item.get("TelNum"));

            if(item.containsKey("EmailAddress"))
                vo.setEmailAddress((String)item.get("EmailAddress"));

            voList.add(vo);
        }

        return voList;
    }

    public MaxPageVO getSearchMaxPage(String accountNum, String name, String telNum, String email) {
        String whereClause = getSQLClause(accountNum, name, telNum, email);

        String sql = "SELECT AccountNum, Name, TelNum, EmailAddress " + "FROM Company " + whereClause;

        sql = "SELECT COUNT(*) AS Number " +
              "FROM ("+sql+")a ";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        long number = (long)list.get(0).get("Number");
        int maxPage = (int) Math.ceil((double)number/ITEM_PER_PAGE);

        MaxPageVO vo = new MaxPageVO();
        vo.setMaxPage(maxPage);

        return vo;
    }

    public CompanyInfoDetailVO getCompanyDetail(String accountNum) {
        String sql = "SELECT AccountNum, Name, TelNum, EmailAddress " +
                     "FROM Company " +
                     "WHERE AccountNum = \'"+accountNum+"\'";

        Map<String, Object> item = mapper.SELECT(sql).get(0);

        CompanyInfoDetailVO vo = new CompanyInfoDetailVO();

        //todo: fix this
        //EvanGuarantyChainInterface.queryCompanyCredit(accountNum);

        if(item.containsKey("AccountNum"))
            vo.setCompanyAccountNum((String) item.get("AccountNum"));
        if(item.containsKey("Name"))
            vo.setCompanyName((String)item.get("Name"));
        if(item.containsKey("TelNum"))
            vo.setCompanyTelNum((String)item.get("TelNum"));
        if(item.containsKey("EmailAddress"))
            vo.setCompanyEmailAddress((String)item.get("EmailAddress"));
        //vo.setCompanyCredit();

        return vo;
    }

    public List<CompanyCreditInfoVO> getCreditInfo(String accountNum, int currentPage) {
        int startIndex = (currentPage-1)*ITEM_PER_PAGE;

        String sql = "SELECT GuarantyId, Type " +
                     "FROM Credit " +
                     "WHERE AccountNum = \'"+accountNum+"\' " +
                     "LIMIT "+startIndex+", "+ITEM_PER_PAGE;

        List<Map<String, Object>> list = mapper.SELECT(sql);
        List<CompanyCreditInfoVO> voList = new ArrayList<>();

        for(Map<String, Object> map : list) {
            String query = (String)map.get("GuarantyId");
            query = "SELECT Name, OwnerName " +
                    "FROM Guaranty " +
                    "WHERE GuarantyId = "+query+" ";
            List<Map<String, Object>> guaList = mapper.SELECT(query);

            CompanyCreditInfoVO vo = new CompanyCreditInfoVO();
            if(map.containsKey("GuarantyId"))
                vo.setGuarantyId((int)map.get("GuarantyId"));
            if(map.containsKey("Name"))
                vo.setGuarantyName((String)guaList.get(0).get("Name"));
            if(map.containsKey("OwnerName"))
                vo.setOwnerName((String)guaList.get(0).get("OwnerName"));
            if(map.containsKey("Type"))
                vo.setType((boolean)map.get("Type"));

            voList.add(vo);
        }

        return voList;
    }

    public MaxPageVO getCreditMaxPage (String accountNum) {
        String sql = "SELECT * " +
                     "FROM Credit " +
                     "WHERE AccountNum = \'"+accountNum+"\' ";
        sql = "SELECT COUNT(*) AS Number " +
              "FROM ("+sql+")a ";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        long number = (long)list.get(0).get("Number");
        int maxPage = (int) Math.ceil((double)number/ITEM_PER_PAGE);

        MaxPageVO vo = new MaxPageVO();
        vo.setMaxPage(maxPage);

        return vo;
    }

    public List<GuarantyInfoVO> getAllGuaranty(String accountNum, int currentPage) {
        int startIndex = (currentPage-1)*ITEM_PER_PAGE;

        String sql = "SELECT GuarantyId, ScopeOfRight, OwnerName, EvaluateValue, Name, State " +
                     "FROM Guaranty " +
                     "WHERE AccountNum = \'"+accountNum+"\' " +
                     "LIMIT "+startIndex+", "+ITEM_PER_PAGE;

        List<Map<String, Object>> list = mapper.SELECT(sql);
        List<GuarantyInfoVO> voList = new ArrayList<>();

        for(Map<String, Object> map : list) {
            GuarantyInfoVO vo = new GuarantyInfoVO();

            if(map.containsKey("GuarantyId"))
                vo.setGuarantyId((int)map.get("GuarantyId"));
            if(map.containsKey("ScopeOfRight"))
                vo.setScopeOfRight((int)map.get("ScopeOfRight"));
            if(map.containsKey("OwnerName"))
                vo.setOwnerName((String)map.get("OwnerName"));
            if(map.containsKey("EvaluateValue"))
                vo.setEvaluateValue((int)map.get("EvaluateValue"));
            if(map.containsKey("Name"))
                vo.setName((String)map.get("Name"));
            if(map.containsKey("State"))
                vo.setState((int)map.get("State"));

            voList.add(vo);
        }

        return voList;
    }

    public MaxPageVO getGuarantyMaxPage(String accountNum) {
        String sql = "SELECT * " +
                     "FROM Guaranty " +
                     "WHERE AccountNum = \'"+accountNum+"\' ";
        sql = "SELECT COUNT(*) AS Number " +
              "FROM ("+sql+")a ";

        List<Map<String, Object>> list = mapper.SELECT(sql);

        long number = (long)list.get(0).get("Number");
        int maxPage = (int) Math.ceil((double)number/ITEM_PER_PAGE);

        MaxPageVO vo = new MaxPageVO();
        vo.setMaxPage(maxPage);

        return vo;
    }

    public BaseResponseVO cancleCompanyAccount(String accountNum) {
        String sql = "DELETE " +
                     "FROM Company " +
                     "WHERE AccountNum = \'"+accountNum+"\' ";

        int result = mapper.DELETE(sql);




        BaseResponseVO vo = new BaseResponseVO();

        if(result==1) {
            vo.setMessage("OK");
        } else {
            vo.setMessage("Error");
        }

        return vo;
    }

    private String getSQLClause(String accountNum, String name, String telNum, String email) {
        String whereClause = "WHERE 1=1 ";

        if(accountNum!=null&&accountNum!="") {
            whereClause += ("AND AccountNum LIKE \'%"+accountNum+"%\' ");
        }
        if(name!=null&&name!="") {
            whereClause += ("AND Name LIKE \'%"+name+"%\' ");
        }
        if(telNum!=null&&telNum!="") {
            whereClause += ("AND TelNum LIKE \'%"+telNum+"%\' ");
        }
        if(email!=null&&email!="") {
            whereClause += ("AND EmailAddress LIKE \'%"+email+"%\' ");
        }

        return whereClause;
    }

}
