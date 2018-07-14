package cn.enderqiu.bcinvestrebuild.app.CreditInfoManagement;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class creditInfoService extends BaseService {
    public List<creditInfoVO> getCompanyCredit(String companyId)
    {
        List<creditInfoVO> cinfoList=new ArrayList<>();

    List<Map<String,Object>> creditinfo=mapper.SELECT("Select * From Credit where AccountNum ="+companyId);
    for(Map<String,Object> m:creditinfo)
    {
        String accountid= " ",reportId =" ",guarantyId =" ",type =" ";
        for(String key: m.keySet()) {

        if(key.equals("AccountNum"))
        {
            accountid=m.get(key).toString();
        }
            if(key.equals("ReportId"))
            {
                reportId=m.get(key).toString();
            }
            if(key.equals("GuarantyId"))
            {
                guarantyId=m.get(key).toString();
            }
            if(key.equals("Type"))
            {
                type=m.get(key).toString();
            }

        }
        creditInfoVO cinfo=new creditInfoVO(accountid,guarantyId,reportId,type);
        cinfoList.add(cinfo);
    }

        return cinfoList;
    }
    public  List<creditInfoVO> getCompanyCredit2Pages(String companyId, int pages)
    {
        return null;
    }


}
