package cn.enderqiu.bcinvestrebuild.app.ReviewInfoManagement;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class ReviewInfoService extends BaseService {
    ReviewCompanyInfoVO getCompanyInfo(String company_id)
    {

        List<Map<String,Object>> mm=mapper.SELECT("Select * from Company where AccountNum ="+company_id);
        if(mm.size()>0) {
            String CompanytNum = mm.get(0).get("AccountNum").toString();
            String Name = mm.get(0).get("Name").toString();
            String telNum=mm.get(0).get("TelNum").toString();
            String emailAddress=mm.get(0).get("EmailAddress").toString();
            String credit=" ";
            ReviewCompanyInfoVO rinfo=new ReviewCompanyInfoVO(CompanytNum,credit,Name,telNum,emailAddress);
            return rinfo;

        }
        else
        {
            return null;
        }



    }
    List<ReviewChainInfoVO> getGuarantyTBCInfo(String user_id_token)
    {
        List<ReviewChainInfoVO> guarantyTBCinfos=new ArrayList<>();
        List<Map<String, Object>> bankUser = mapper.SELECT("Select * from Authorization where Token =" + user_id_token);
        List<Map<String,Object>> m=mapper.SELECT("Select g.AccountNum as CompanyId,r.ReportId,a.AccountNum as AuthorityId," +
                "g.Name,g.EvaluateValue,g.guarantyId"+
                " from Guaranty g,Report r,Authorization a where g.Type = 1 and r.reportId= g.reportId and r.AccountNum = a.AccountNum " +
                "and a.AccountNum ="+
        bankUser.get(0).get("AccountNum"));
        if(m.size()>0) {
            for (Map<String, Object> mm : m) {

                ReviewCompanyInfoVO reviewCompanyInfoVO = getCompanyInfo(mm.get("CompanyId").toString());
                String authorityId=mm.get("AuthorityId").toString();
                String guarantyName=mm.get("Name").toString();
                String evaluateValue=mm.get("EvaluateValue").toString();
                String guarantyId=mm.get("guarantyId").toString();
                String reportId=mm.get("ReportId").toString();

                ReviewChainInfoVO reviewChainInfoVO=new ReviewChainInfoVO(reviewCompanyInfoVO,  guarantyId,  reportId,  authorityId,  guarantyName,  evaluateValue);
                guarantyTBCinfos.add(reviewChainInfoVO);
            }
            return  guarantyTBCinfos;
        }
        else
        {
return null;
        }

    }
    UpdateGuarantyValueVO updateGuarantyValueVO(String guarantyId,String value)
    {
        String update="update Guaranty set EvaluateValue =" + value+" where guarantyId =" +guarantyId;
        int m=mapper.UPDATE(update);
        if(m==0)
        {
            return new UpdateGuarantyValueVO("error");
        }
        else
        {
            return new UpdateGuarantyValueVO("success");
        }

    }

}
