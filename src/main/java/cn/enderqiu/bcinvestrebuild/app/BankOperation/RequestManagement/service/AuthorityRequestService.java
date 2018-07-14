package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service;

import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.CompanyVO;
import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.ProtocolVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service.GuarantyManagementService;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.impls.CCGuarantyChainInterfaceImpl;
import cn.ssyram.blockchain.interfaces.CCGuarantyChainInerface;
import com.generator.tables.Company;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
public class AuthorityRequestService extends BaseService{
    CCGuarantyChainInerface ccGuarantyChainInerface = new CCGuarantyChainInterfaceImpl();
    public String TokenToAccountNum(String token) {
        String sqlSentence = "SELECT accountNum FROM company WHERE token = '" + token + "';";
        List<Map<String, Object>> result = mapper.SELECT(sqlSentence);
        String accountNum = mapper.SELECT(sqlSentence).get(0).get("accountNum").toString();
        return accountNum;
    }

    public CompanyVO findCompany(String accountNum){
        String sqlSentence = "SELECT * FROM company WHERE accountNum = '"+accountNum+"';";
        Map<String, Object> result = mapper.SELECT(sqlSentence).get(0);
        CompanyVO companyVO = new CompanyVO();
        extract(companyVO,result);
        return companyVO;
    }
    public List<CompanyVO> findCompaniesByState(String state,int page){
        List<Map<String,Object>> results = null;
        List<CompanyVO> companies = new ArrayList<>();
        int pageStartIndex = (page-1)*20;
        String sqlSentence = "SELECT * FROM company WHERE state = '"+state+"' ORDER BY accountNum LIMIT "+pageStartIndex+",20"+";";
        results = mapper.SELECT(sqlSentence);
        companies = getVOListByResult(results,CompanyVO.class);
        return companies;
    }
    public int findCompaniesCount(String state){
        String sqlSentence = "SELECT COUNT(*) FROM company WHERE state = '"+state+"' ORDER BY accountNum;";
        List<Map<String,Object>> results = mapper.SELECT(sqlSentence);
        int count = Integer.parseInt(results.get(0).get("COUNT(*)").toString());
        return count;
    }
    public MaxPageVO findMaxPage(String[] states){
        int count = 0;
        int maxPage = 0;
        for(String state :states){
            count+=findCompaniesCount(state);
        }
        if(count>0){
            maxPage = count/21+1;
        }
        MaxPageVO maxPageVO = new MaxPageVO();
        maxPageVO.setMaxPage(maxPage);
        return maxPageVO;
    }
    public int changeCompanyState(String accountNum,String state){
        String sqlSentence = "UPDATE company SET state = '"+state+"' WHERE accountNum = '"+accountNum+"';";
        return mapper.UPDATE(sqlSentence);
    }
    public int changeGuarantyState(int guarantyId,int state){
        String sqlSentence = "UPDATE guaranty SET state = "+state+" WHERE guarantyId = "+guarantyId+";";
        return mapper.UPDATE(sqlSentence);
    }
}
