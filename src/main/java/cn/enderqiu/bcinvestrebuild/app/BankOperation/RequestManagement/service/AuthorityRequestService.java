package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service;

import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.CompanyVO;
import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.ProtocolVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service.GuarantyManagementService;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.enderqiu.bcinvestrebuild.util.GuarantyChainUtil;
import cn.ssyram.blockchain.impls.CCGuarantyChainInterfaceImpl;
import cn.ssyram.blockchain.interfaces.CCGuarantyChainInerface;
import cn.ssyram.blockchain.interfaces.GuarantyChain;
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
    public ReturnVO intToReturnVO(int influence){
        ReturnVO returnVO = new ReturnVO();
        returnVO.setInfluence(influence);
        return returnVO;
    }
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
    public MaxPageVO findCompanyMaxPage(String[] states){
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
    public int findGuarantiesCount(int stateNum){
        String sqlSentence = "SELECT COUNT(*) FROM guaranty WHERE state = "+stateNum+" ORDER BY accountNum;";
        List<Map<String,Object>> results = mapper.SELECT(sqlSentence);
        int count = Integer.parseInt(results.get(0).get("COUNT(*)").toString());
        return count;
    }
    public List<GuarantyVO> findGuarantiesByState(int stateNum,int page){
        List<Map<String,Object>> results = null;
        List<GuarantyVO> guaranties = new ArrayList<>();
        int pageStartIndex = (page-1)*20;
        String sqlSentence = "SELECT * FROM guaranty WHERE state = "+stateNum+" ORDER BY accountNum LIMIT "+pageStartIndex+",20"+";";
        results = mapper.SELECT(sqlSentence);
        guaranties = getVOListByResult(results,GuarantyVO.class);
        return guaranties;
    }
    public MaxPageVO findGuarantyMaxPage(int[] stateNums){
        int count = 0;
        int maxPage = 0;
        for(int stateNum :stateNums){
            switch (stateNum){
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    count+= GuarantyChain.chain.queryGuarantyIdByState(stateNum).size();break;
                default:
                    count+=findGuarantiesCount(stateNum);
            }
        }
        if(count>0){
            maxPage = count/21+1;
        }
        MaxPageVO maxPageVO = new MaxPageVO();
        maxPageVO.setMaxPage(maxPage);
        return maxPageVO;
    }
    public ReturnVO changeCompanyState(String accountNum,String state){
        String sqlSentence = "UPDATE company SET state = '"+state+"' WHERE accountNum = '"+accountNum+"';";
        return intToReturnVO(mapper.UPDATE(sqlSentence));
    }
    public ReturnVO changeGuarantyState(int guarantyId,int state){
        ReturnVO returnVO = new ReturnVO();
        String message = GuarantyChainUtil.updateState(guarantyId,3);
        returnVO.setMessage(message);
        if(message.equals("ok")||message.equals("submitted")){
            returnVO.setInfluence(1);
        }
        return returnVO;
    }
}
