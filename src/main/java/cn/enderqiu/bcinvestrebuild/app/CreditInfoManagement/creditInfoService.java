package cn.enderqiu.bcinvestrebuild.app.CreditInfoManagement;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.impls.CreditChainImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class creditInfoService extends BaseService {


    public List<creditInfoVO> getCompanyCredit(String user_id_token)
    {
        List<Map<String,Object>> mm=mapper.SELECT("Select * from Company where Token ="+user_id_token);
        String CompanytNum=mm.get(0).get("AccountNum").toString();

        List<creditInfoVO> cinfoList=new ArrayList<>();



    List<Map<String,Object>> creditinfo=mapper.SELECT("Select * from Credit where AccountNum=" +CompanytNum);


    for(Map<String, Object> m:creditinfo)
    {
        String accountid= " ",reportId =" ",guarantyId =" ",type =" ",duetime=" ",guarantyName=" ";



            accountid=m.get("AccountNum").toString();
            reportId=m.get("ReportId").toString();
            guarantyId=m.get("GuarantyId").toString();
            type=m.get("Type").toString();
            List<Map<String,Object>> reportinfo=mapper.SELECT("Select * from Report where ReportId=" +reportId);
            duetime=reportinfo.get(0).get("Date").toString();
            List<Map<String,Object>> guarantyInfo=mapper.SELECT("Select * from Guaranty where GuarantyId=" +guarantyId);
            guarantyName=guarantyInfo.get(0).get("Name").toString();


        creditInfoVO cinfo=new creditInfoVO(accountid,guarantyId,reportId,type,duetime,guarantyName);
        cinfoList.add(cinfo);
    }

        return cinfoList;
    }


    public  List<creditInfoVO> getCompanyCredit2Pages(String companyId, int pages)
    {
        return null;
    }



}
