package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service;

import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.ProtocolVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service.GuarantyManagementService;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.enderqiu.bcinvestrebuild.util.GuarantyChainUtil;
import cn.ssyram.blockchain.impls.CCGuarantyChainInterfaceImpl;
import cn.ssyram.blockchain.interfaces.CCGuarantyChainInerface;
import cn.ssyram.blockchain.interfaces.GuarantyChain;
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
        String sqlSentence = "SELECT * FROM guaranty WHERE guarantyId = '"+guarantyId+"';";
        Map<String, Object> result = null;
        List<Map<String, Object>> l = mapper.SELECT(sqlSentence);
        GuarantyVO guarantyVO = new GuarantyVO();
        if (l.size() != 0) {
            result = l.get(0);
            extract(guarantyVO,result);
        }
        return guarantyVO;
    }
    public void putGuarantiesToTemp(int[] stateNums){
        List<Map<String,Object>> guarantyIdList = null;

        for(int stateNum :stateNums)
        {
            switch(stateNum){
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    guarantyIdList = GuarantyChain.chain.queryGuarantyIdByState(stateNum);
                    for(Map<String,Object> m:guarantyIdList){
                        int guarantyId = Integer.parseInt(m.get("id").toString());
                        String sqlSentence = "INSERT INTO temp values(null,"+guarantyId+");";
                        mapper.INSERT(sqlSentence);
                    }
                    break;
                default:
                    String sqlSentence = "SELECT guarantyId FROM guaranty WHERE state = "+stateNum+";";
                    guarantyIdList = mapper.SELECT(sqlSentence);
                    for(Map<String,Object> m:guarantyIdList){
                        int guarantyId = Integer.parseInt(m.get("guarantyId").toString());
                        String sql = "INSERT INTO temp values(null,"+guarantyId+");";
                        mapper.INSERT(sql);
                        }
                    }
            }
        }
    public List<GuarantyVO> findGuarantiesByStates(int[] stateNums,int page){
        putGuarantiesToTemp(stateNums);
        List<GuarantyVO> guaranties = new ArrayList<>();
        int pageStartIndex = (page-1)*20;
        String sentence = "SELECT guarantyId FROM temp ORDER BY guarantyId LIMIT "+pageStartIndex+",20"+";";
        List<Map<String,Object>> guarantyIdListByPage = mapper.SELECT(sentence);
        for(Map<String,Object> m:guarantyIdListByPage){
            int guarantyId = Integer.parseInt(m.get("guarantyId").toString());
            guaranties.add(findGuaranty(guarantyId));
        }
        mapper.DELETE("Delete from temp where 1=1");
        return guaranties;
    }

    public MaxPageVO findMaxPage(int[] stateNums){
        putGuarantiesToTemp(stateNums);
        String sqlSentence = "SELECT COUNT(*) FROM temp;";
        List<Map<String,Object>> results = mapper.SELECT(sqlSentence);
        int count = Integer.parseInt(results.get(0).get("COUNT(*)").toString());
        mapper.DELETE("Delete from temp where 1=1");
        int maxPage = 0;
        if(count>0){
            maxPage = count/21+1;
        }
        MaxPageVO maxPageVO = new MaxPageVO();
        maxPageVO.setMaxPage(maxPage);
        return maxPageVO;
    }
    public ReturnVO repay(int guarantyId){
        int isSuccess = 0;
        ReturnVO returnVO = new ReturnVO();
        String message = GuarantyChainUtil.updateState(guarantyId,4);
        returnVO.setMessage(message);
        if(message.equals("ok")||message.equals("submitted")){
            isSuccess = 1;
        }
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
            returnVO.setInfluence(mapper.UPDATE(sqlSentence2));



            return returnVO;
        }
        returnVO.setInfluence(0);
        return returnVO;
    }
    public ReturnVO mortgage(int guarantyId){
        int isSuccess = 0;
        ReturnVO returnVO = new ReturnVO();
        String message = GuarantyChainUtil.updateState(guarantyId,6);
        returnVO.setMessage(message);
        if(message.equals("ok")||message.equals("submitted")){
            isSuccess = 1;
        }
        if(isSuccess>0){
            String sql = "select duration from guaranty inner join report on guaranty.reportId = report.reportId where guarantyId = "+guarantyId+";";
            int duration = Integer.parseInt(mapper.SELECT(sql).get(0).get("duration").toString());
            String sqlSentence = "INSERT INTO protocol(protocolId,guarantyId,startDate,duration,state) VALUES("+null+","+guarantyId+",CURDATE(),"+duration+",'repaying');";
            int result = mapper.INSERT(sqlSentence);
            returnVO.setInfluence(result);
            return returnVO;
        }
        returnVO.setInfluence(0);
        return returnVO;
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
}
