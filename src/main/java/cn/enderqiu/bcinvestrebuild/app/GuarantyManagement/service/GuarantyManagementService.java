package cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service;

import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.GuarantyVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.HouseVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.LandVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.MachineVO;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GuarantyManagementService extends BaseService{
    public String TokenToAccountNum(String token){
        String sqlSentence = "SELECT accountNum FROM company WHERE token = "+token+";";
        String accountNum = mapper.SELECT(sqlSentence).get(0).get("AccountNum").toString();
        return accountNum;
    }
    public int putGuarantyToBC(String guarantyId){
        String sqlSentence = "UPDATE guaranty SET state = '3' WHERE guarantyId = "+guarantyId+";";
        return mapper.UPDATE(sqlSentence);
    }
    public int deleteGuaranty(String guarantyId){
        String sqlSentence = "DELETE FROM guaranty WHERE guarantyId = "+guarantyId+";";
        return mapper.DELETE(sqlSentence);
    }
    public HouseVO findHouse(String guarantyId){
        String sqlSentence1 = "SELECT * FROM guaranty WHERE guarantyId = "+guarantyId+";";
        String sqlSentence2 = "SELECT * FROM house WHERE guarantyId = "+guarantyId+";";
        Map<String, Object> result1 = mapper.SELECT(sqlSentence1).get(0);
        Map<String, Object> result2 = mapper.SELECT(sqlSentence2).get(0);
        HouseVO houseVO = new HouseVO();
        extract(houseVO,result1);
        extract(houseVO,result2);
        return houseVO;
    }
    public LandVO findLand(String guarantyId){
        String sqlSentence1 = "SELECT * FROM guaranty WHERE guarantyId = "+guarantyId+";";
        String sqlSentence2 = "SELECT * FROM land WHERE guarantyId = "+guarantyId+";";
        Map<String, Object> result1 = mapper.SELECT(sqlSentence1).get(0);
        Map<String, Object> result2 = mapper.SELECT(sqlSentence2).get(0);
        LandVO landVO = new LandVO();
        extract(landVO,result1);
        extract(landVO,result2);
        return landVO;
    }
    public MachineVO findMachine(String guarantyId){
        String sqlSentence1 = "SELECT * FROM guaranty WHERE guarantyId = "+guarantyId+";";
        String sqlSentence2 = "SELECT * FROM machine WHERE guarantyId = "+guarantyId+";";
        Map<String, Object> result1 = mapper.SELECT(sqlSentence1).get(0);
        Map<String, Object> result2 = mapper.SELECT(sqlSentence2).get(0);
        MachineVO machineVO = new MachineVO();
        extract(machineVO,result1);
        extract(machineVO,result2);
        return machineVO;
    }
    public List<GuarantyVO> findGuarantiesByState(String user_id_token,int stateNum,int page){
        int pageStartIndex = (page-1)*20;
        String accountNum = TokenToAccountNum(user_id_token);
        String sqlSentence = "SELECT * FROM guaranty WHERE accountNum = "+accountNum+"AND state = "+stateNum+"ORDER BY accountNum LIMIT "+pageStartIndex+",20"+";";
        List<Map<String,Object>> results = mapper.SELECT(sqlSentence);
        List<GuarantyVO> Guaranties = getVOListByResult(results,GuarantyVO.class);
        return Guaranties;
    }
    public int createGuaranty(String user_id_token,GuarantyVO guarantyVO){
        String accountNum = TokenToAccountNum(user_id_token);
        String sqlSentence1 = "INSERT INTO guaranty(GuarantyId,AccountNum,State,ScopeOfRight,OwnerName,Type,EvaluateValue,Name) VALUES("+
                null+","+accountNum+","+0+","+guarantyVO.getScopeOfRight()+","+guarantyVO.getOwnerName()+","+0+","+guarantyVO.getEvaluateValue()+","+guarantyVO.getName()+");";
        mapper.INSERT(sqlSentence1);
        int guarantyId = Integer.parseInt(mapper.SELECT("SELECT LAST_INSERT_ID();").get(0).get(0).toString());
        return guarantyId;
    }
    public void createHouse(String user_id_token,HouseVO houseVO){
        int guarantyId = createGuaranty(user_id_token,houseVO);
        String sqlSentence2 = "INSERT INTO house(Addr,Zip,HousingCertificatedId,GuarantyId) VALUES("+
                houseVO.getAddr()+","+houseVO.getZip()+","+houseVO.getHousingCertificatedId()+","+guarantyId+");";
    }
    public void createLand(String user_id_token,LandVO landVO){
        int guarantyId = createGuaranty(user_id_token,landVO);
        String sqlSentence2 = "INSERT INTO house(Addr,Area,GuarantyId) VALUES("+
                landVO.getAddr()+","+landVO.getArea()+","+guarantyId+");";
    }
    public void createMachine(String user_id_token,MachineVO machineVO){
        int guarantyId = createGuaranty(user_id_token,machineVO);
        String sqlSentence2 = "INSERT INTO house(UsedDays,Producer,Model,GuarantyId) VALUES("+
                machineVO.getUsedDays()+","+machineVO.getProducer()+","+machineVO.getModel()+","+guarantyId+");";
    }


}
