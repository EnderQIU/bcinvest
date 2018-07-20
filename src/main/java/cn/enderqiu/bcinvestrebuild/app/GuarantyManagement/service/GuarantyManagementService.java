package cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service;

import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.enderqiu.bcinvestrebuild.util.GuarantyChainUtil;
import cn.ssyram.blockchain.impls.CCGuarantyChainInterfaceImpl;
import cn.ssyram.blockchain.impls.GurantyChainImpl;
import cn.ssyram.blockchain.interfaces.CCGuarantyChainInerface;
import cn.ssyram.blockchain.interfaces.GuarantyChain;
import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GuarantyManagementService extends BaseService{
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
    public ReturnVO putGuarantyToBC(int guarantyId){
        ReturnVO returnVO = new ReturnVO();
        String message = GuarantyChainUtil.updateState(guarantyId,4);
        returnVO.setMessage(message);
        if(message.equals("ok")||message.equals("submitted")){
            returnVO.setInfluence(1);
        }
        return returnVO;
    }
    public ReturnVO downBC(int guarantyId){
        ReturnVO returnVO = new ReturnVO();
        String message = GuarantyChainUtil.updateState(guarantyId,1);
        returnVO.setMessage(message);
        if(message.equals("ok")||message.equals("submitted")){
            returnVO.setInfluence(1);
        }
        return returnVO;
    }
    public ReturnVO deleteGuaranty(int guarantyId){
        String sqlSentence = "DELETE FROM guaranty WHERE guarantyId = "+guarantyId+";";
        return  intToReturnVO(mapper.DELETE(sqlSentence));
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
    public GuarantyVO findGuarantyByCompany(String accountNum,int guarantyId){
        String sqlSentence = "SELECT * FROM guaranty WHERE guarantyId = "+guarantyId+" AND accountNum = '"+accountNum+"';";
        Map<String, Object> result = mapper.SELECT(sqlSentence).get(0);
        GuarantyVO guarantyVO = new GuarantyVO();
        extract(guarantyVO,result);
        return guarantyVO;
    }
    public String getCompany(int guarantyId){
        String sql = "SELECT accountNum FROM guaranty WHERE guarantyId = "+guarantyId+";";
        List<Map<String,Object>> result = mapper.SELECT(sql);
        String accountNum = result.get(0).get("accountNum").toString();
        return accountNum;
    }
    public List<GuarantyVO> findGuarantiesByStates(String user_id_token,int[] stateNums,int page){
        List<Map<String,Object>> guarantyIdList = null;
        List<GuarantyVO> guaranties = new ArrayList<>();
        String accountNum = TokenToAccountNum(user_id_token);
        int pageStartIndex = (page-1)*20;
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
                        if(getCompany(guarantyId).equals(accountNum)){
                            String sqlSentence = "INSERT INTO temp values(null,"+guarantyId+");";
                            mapper.INSERT(sqlSentence);
                        }
                    }
                    break;
                default:
                    String sqlSentence = "SELECT guarantyId FROM guaranty WHERE accountNum = '"+accountNum+"' AND state = "+stateNum+";";
                    guarantyIdList = mapper.SELECT(sqlSentence);
                    for(Map<String,Object> m:guarantyIdList){
                        int guarantyId = Integer.parseInt(m.get("guarantyId").toString());
                        if(getCompany(guarantyId).equals(accountNum)){
                            String sql = "INSERT INTO temp values(null,"+guarantyId+");";
                            mapper.INSERT(sql);
                        }
                    }
            }

        }
        String sentence = "SELECT guarantyId FROM temp ORDER BY guarantyId LIMIT "+pageStartIndex+",20"+";";
        List<Map<String,Object>> guarantyIdListByPage = mapper.SELECT(sentence);
        for(Map<String,Object> m:guarantyIdListByPage){
            int guarantyId = Integer.parseInt(m.get("guarantyId").toString());
            guaranties.add(findGuarantyByCompany(accountNum,guarantyId));
        }
        mapper.DELETE("Delete from temp where 1=1");
        return guaranties;
    }
    public int findGuarantiesCount(String user_id_token,int stateNum){
        String accountNum = TokenToAccountNum(user_id_token);
        String sqlSentence = "SELECT COUNT(*) FROM guaranty WHERE accountNum = '"+accountNum+"' AND state = "+stateNum+" ORDER BY accountNum;";
        List<Map<String,Object>> results = mapper.SELECT(sqlSentence);
        int count = Integer.parseInt(results.get(0).get("COUNT(*)").toString());
        return count;
    }
    public MaxPageVO findMaxPage(String user_id_token, int[] stateNums){
        int count = 0;
        int maxPage = 0;
        for(int stateNum :stateNums){
            switch (stateNum){
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    String accountNum = TokenToAccountNum(user_id_token);
                   // count+=ccGuarantyChainInerface.queryGuarantyIdByState(stateNum).size();break;
                default:
                    count+=findGuarantiesCount(user_id_token,stateNum);
            }
        }
        if(count>0){
            maxPage = count/21+1;
        }
        MaxPageVO maxPageVO = new MaxPageVO();
        maxPageVO.setMaxPage(maxPage);
        return maxPageVO;
    }
    public int createGuaranty(String user_id_token,GuarantyVO guarantyVO,int type){
        String accountNum = TokenToAccountNum(user_id_token);
        String sqlSentence1 = "INSERT INTO guaranty(GuarantyId,AccountNum,State,ScopeOfRight,OwnerName,Type,Name) VALUES("+
                null+",'"+accountNum+"',"+0+","+guarantyVO.getScopeOfRight()+",'"+guarantyVO.getOwnerName()+"',"+type+",'"+guarantyVO.getName()+"');";
        mapper.INSERT(sqlSentence1);
        int guarantyId = Integer.parseInt(mapper.SELECT("SELECT LAST_INSERT_ID();").get(0).get("LAST_INSERT_ID()").toString());
        return guarantyId;
    }
    public ReturnVO createHouse(String user_id_token,HouseVO houseVO){
        int guarantyId = createGuaranty(user_id_token,houseVO,0);
        String sqlSentence2 = "INSERT INTO house(Addr,Zip,HousingCertificatedId,GuarantyId) VALUES('"+
                houseVO.getAddr()+"','"+houseVO.getZip()+"','"+houseVO.getHousingCertificatedId()+"',"+guarantyId+");";
        ReturnVO returnVO = intToReturnVO(mapper.INSERT(sqlSentence2));
        return returnVO;
    }
    public ReturnVO createLand(String user_id_token,LandVO landVO){
        int guarantyId = createGuaranty(user_id_token,landVO,1);
        String sqlSentence2 = "INSERT INTO land(Addr,Area,GuarantyId) VALUES('"+
                landVO.getAddr()+"','"+landVO.getArea()+"',"+guarantyId+");";
        ReturnVO returnVO = intToReturnVO(mapper.INSERT(sqlSentence2));
        return returnVO;
    }
    public ReturnVO createMachine(String user_id_token,MachineVO machineVO){
        int guarantyId = createGuaranty(user_id_token,machineVO,2);
        String sqlSentence2 = "INSERT INTO machine(UsedDays,Producer,Model,GuarantyId) VALUES("+
                machineVO.getUsedDays()+",'"+machineVO.getProducer()+"','"+machineVO.getModel()+"',"+guarantyId+");";
        ReturnVO returnVO = intToReturnVO(mapper.INSERT(sqlSentence2));
        return returnVO;
    }


}
