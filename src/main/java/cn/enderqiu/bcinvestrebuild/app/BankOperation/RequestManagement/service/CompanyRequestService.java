package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service;

import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.ProtocolVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service.GuarantyManagementService;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.impls.CCGuarantyChainInterfaceImpl;
import cn.ssyram.blockchain.interfaces.CCGuarantyChainInerface;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class CompanyRequestService extends BaseService{
    CCGuarantyChainInerface ccGuarantyChainInerface = new CCGuarantyChainInterfaceImpl();
    public ReturnVO intToReturnVO(int influence){
        ReturnVO returnVO = new ReturnVO();
        returnVO.setInfluence(influence);
        return returnVO;
    }
    public String TokenToAccountNum(String token){
        String sqlSentence = "SELECT accountNum FROM company WHERE token = '"+token+"';";
        List<Map<String,Object>> result = mapper.SELECT(sqlSentence);
        String accountNum = mapper.SELECT(sqlSentence).get(0).get("accountNum").toString();
        return accountNum;
    }

    public GuarantyVO findGuaranty(int guarantyId){
        String sqlSentence = "SELECT * FROM guaranty WHERE guarantyId = "+guarantyId+";";
        Map<String, Object> result = mapper.SELECT(sqlSentence).get(0);
        GuarantyVO guarantyVO = new GuarantyVO();
        extract(guarantyVO,result);
        return guarantyVO;
    }
    public List<GuarantyVO> findGuarantiesByState(int stateNum,int page){
        List<GuarantyVO> guaranties = new ArrayList<>();
        List<Map<String,Object>> guarantyIdList = ccGuarantyChainInerface.queryGuarantyIdByState(stateNum);
        for(Map<String,Object> m:guarantyIdList){
            int guarantyId = Integer.parseInt(m.get("guarantyId").toString());
            guaranties.add(findGuaranty(guarantyId));
        }
        return guaranties;
    }

    public MaxPageVO findMaxPage(int[] stateNums){
        int count = 0;
        int maxPage = 0;
        for(int stateNum :stateNums){
            count+=ccGuarantyChainInerface.queryGuarantyIdByState(stateNum).size();
        }
        if(count>0){
            maxPage = count/21+1;
        }
        MaxPageVO maxPageVO = new MaxPageVO();
        maxPageVO.setMaxPage(maxPage);
        return maxPageVO;
    }
    public ReturnVO repay(int guarantyId){
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
            return intToReturnVO(mapper.UPDATE(sqlSentence2));
        }
        return intToReturnVO(0);
    }
    public ReturnVO mortgage(int guarantyId,int duration){
        //int isSuccess = 1;
        int isSuccess = ccGuarantyChainInerface.updateState(guarantyId,6);
        if(isSuccess>0){
            String sqlSentence = "INSERT INTO protocol(protocolId,guarantyId,startDate,duration,state) VALUES("+null+","+guarantyId+",CURDATE(),"+duration+",'repaying');";
            return intToReturnVO(mapper.INSERT(sqlSentence));
        }
        return intToReturnVO(0);
    }
}
