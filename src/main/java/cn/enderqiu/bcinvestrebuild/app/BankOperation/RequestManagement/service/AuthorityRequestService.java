package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service;

import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.CompanyVO;
import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.ProtocolVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
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
    public String TokenToAccountNum(String token){
        String sqlSentence = "SELECT accountNum FROM company WHERE token = '"+token+"';";
        List<Map<String,Object>> result = mapper.SELECT(sqlSentence);
        String accountNum = mapper.SELECT(sqlSentence).get(0).get("accountNum").toString();
        return accountNum;
    }

    public int deleteGuaranty(int guarantyId){
        String sqlSentence = "DELETE FROM guaranty WHERE guarantyId = "+guarantyId+";";
        return mapper.DELETE(sqlSentence);
    }
    public HouseVO findHouse(int guarantyId){
        String sqlSentence1 = "SELECT * FROM guaranty WHERE guarantyId = "+guarantyId+";";
        String sqlSentence2 = "SELECT * FROM house WHERE guarantyId = "+guarantyId+";";
        Map<String, Object> result1 = mapper.SELECT(sqlSentence1).get(0);
        Map<String, Object> result2 = mapper.SELECT(sqlSentence2).get(0);
        HouseVO houseVO = new HouseVO();
        extract(houseVO,result1);
        extract(houseVO,result2);
        return houseVO;
    }
    public LandVO findLand(int guarantyId){
        String sqlSentence1 = "SELECT * FROM guaranty WHERE guarantyId = "+guarantyId+";";
        String sqlSentence2 = "SELECT * FROM land WHERE guarantyId = "+guarantyId+";";
        Map<String, Object> result1 = mapper.SELECT(sqlSentence1).get(0);
        Map<String, Object> result2 = mapper.SELECT(sqlSentence2).get(0);
        LandVO landVO = new LandVO();
        extract(landVO,result1);
        extract(landVO,result2);
        return landVO;
    }
    public MachineVO findMachine(int guarantyId){
        String sqlSentence1 = "SELECT * FROM guaranty WHERE guarantyId = "+guarantyId+";";
        String sqlSentence2 = "SELECT * FROM machine WHERE guarantyId = "+guarantyId+";";
        Map<String, Object> result1 = mapper.SELECT(sqlSentence1).get(0);
        Map<String, Object> result2 = mapper.SELECT(sqlSentence2).get(0);
        MachineVO machineVO = new MachineVO();
        extract(machineVO,result1);
        extract(machineVO,result2);
        return machineVO;
    }
    public CompanyVO findCompany(String accountNum){
        String sqlSentence = "SELECT * FROM company WHERE accountNum = '"+accountNum+"';";
        Map<String, Object> result = mapper.SELECT(sqlSentence).get(0);
        CompanyVO companyVO = new CompanyVO();
        extract(companyVO,result);
        return companyVO;
    }
    public List<CompanyVO> findCompaniesByState(int stateNum,int page){
        List<Map<String,Object>> results = null;
        List<CompanyVO> companies = new ArrayList<>();
        int pageStartIndex = (page-1)*20;
        String sqlSentence = "SELECT * FROM company WHERE state = "+stateNum+" ORDER BY accountNum LIMIT "+pageStartIndex+",20"+";";
        results = mapper.SELECT(sqlSentence);
        companies = getVOListByResult(results,CompanyVO.class);
        return companies;
    }

    public MaxPageVO findMaxPage(int[] stateNums){
        int count = 0;
        int maxPage = 0;
        for(int stateNum :stateNums){
            count+=ccGuarantyChainInerface.queryGuarantyIdByBank(stateNum).size();
        }
        if(count>0){
            maxPage = count/21+1;
        }
        MaxPageVO maxPageVO = new MaxPageVO();
        maxPageVO.setMaxPage(maxPage);
        return maxPageVO;
    }
    public int repay(int guarantyId){
        //int isSuccess = 1;
        int isSuccess = ccGuarantyChainInerface.updateState(guarantyId,4);
        if(isSuccess>0){
            Date curdate = new Date(new java.util.Date().getTime());
            String sqlSentence = "SELECT startDate,duration FROM protocol WHERE guarantyId = "+guarantyId+";";
            Map<String,Object> result = mapper.SELECT(sqlSentence).get(0);
            ProtocolVO protocolVO = new ProtocolVO();
            extract(protocolVO,result);
            Date startDate = protocolVO.getStartDate();
            int duration = protocolVO.getDuration();
            Calendar start = Calendar.getInstance();
            start.setTime(startDate);
            start.add(Calendar.DAY_OF_YEAR,duration);
            Date overdueDate = new Date(start.getTime().getTime());
            if(curdate.after(overdueDate)){
                protocolVO.setState("overdueCompleted");
            }else {
                protocolVO.setState("completed");
            }
            protocolVO.setEndDate(curdate);
            String sqlSentence2 = "UPDATE  protocol SET endDate = '"+curdate+"',state = '"+protocolVO.getState()+"' WHERE guarantyId = "+guarantyId+";";
            return mapper.UPDATE(sqlSentence2);
        }
        return 0;
    }
    public int mortgage(int guarantyId,int duration){
        //int isSuccess = 1;
        int isSuccess = ccGuarantyChainInerface.updateState(guarantyId,6);
        if(isSuccess>0){
            String sqlSentence = "INSERT INTO protocol(protocolId,guarantyId,startDate,duration,state) VALUES("+null+","+guarantyId+",CURDATE(),"+duration+",'repaying');";
            return mapper.INSERT(sqlSentence);
        }
        return 0;
    }
}
