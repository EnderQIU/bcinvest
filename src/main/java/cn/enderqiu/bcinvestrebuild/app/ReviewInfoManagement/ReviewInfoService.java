package cn.enderqiu.bcinvestrebuild.app.ReviewInfoManagement;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.impls.CreditChainImpl;
import com.generator.tables.CreditChain;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class ReviewInfoService extends BaseService {
    private static CreditChainImpl creditChain=new CreditChainImpl();

    ReviewCompanyInfoVO getCompanyInfo(String company_id)
    {

        List<Map<String,Object>> mm=mapper.SELECT("Select * from Company where AccountNum ="+company_id);
        if(mm.size()>0) {
            String CompanytNum = mm.get(0).get("AccountNum").toString();
            String Name = mm.get(0).get("Name").toString();
            String telNum=mm.get(0).get("TelNum").toString();
            String emailAddress=mm.get(0).get("EmailAddress").toString();
            String credit=" ";
            ReviewCompanyInfoVO rinfo=new ReviewCompanyInfoVO(CompanytNum,Name,telNum,emailAddress);
            return rinfo;

        }
        else
        {
            return null;
        }



    }
    List<ReviewCompanyInfoVO> getCompanyStateUnapplied()
    {
        List<ReviewCompanyInfoVO> rcInfos=new ArrayList<>();

        List<Map<String,Object>> mm=mapper.SELECT("Select * from Company where status = 'checking_1' ");
        if(mm.size()>0) {
            for(Map<String,Object> m:mm) {
                String CompanytNum = m.get("AccountNum").toString();
                String Name = m.get("Name").toString();
                String telNum = m.get("TelNum").toString();
                String emailAddress = m.get("EmailAddress").toString();

                List<Map<String, Object>> creditinfo = creditChain.getCompanyCreditList(CompanytNum);



                ReviewCompanyInfoVO rinfo = new ReviewCompanyInfoVO(CompanytNum, Name, telNum, emailAddress);
                rcInfos.add(rinfo);
            }


        }

            return rcInfos;

    }
    List<ReviewChainInfoVO> getGuarantyTBCInfo(String user_id_token)
    {
        List<ReviewChainInfoVO> guarantyTBCinfos=new ArrayList<>();
        List<Map<String, Object>> bankUser = mapper.SELECT("Select * from Authorization where Token =" +"'" +user_id_token+"'");
        List<Map<String,Object>> m=mapper.SELECT("Select g.AccountNum as CompanyId,r.ReportId,a.AccountNum as AuthorityId," +
                "g.Name,g.EvaluateValue,g.guarantyId"+
                " from Guaranty g,Report r,Authorization a where g.Type = 1 and r.reportId= g.reportId and r.AccountNum = a.AccountNum " +
                "and a.AccountNum ="+"'"+
        bankUser.get(0).get("AccountNum")+"'");
        if(m.size()>0) {
            for (Map<String, Object> mm : m) {

                ReviewCompanyInfoVO reviewCompanyInfoVO = getCompanyInfo(mm.get("CompanyId").toString());
                String authorityId = mm.get("AuthorityId").toString();
                String guarantyName = mm.get("Name").toString();
                String evaluateValue = mm.get("EvaluateValue").toString();
                String guarantyId = mm.get("guarantyId").toString();
                String reportId = mm.get("ReportId").toString();

                List<Map<String, Object>> creditinfo = creditChain.getCompanyCreditList(mm.get("CompanyId").toString());
                String credit = " ";
                if (creditinfo.size() > 0) {
                    credit = creditinfo.get(0).get("value").toString();
                }


                ReviewChainInfoVO reviewChainInfoVO = new ReviewChainInfoVO(reviewCompanyInfoVO, guarantyId, reportId, authorityId, guarantyName, evaluateValue, credit);
                guarantyTBCinfos.add(reviewChainInfoVO);
            }

        }
        return guarantyTBCinfos;

    }
    UpdateGuarantyValueVO updateGuarantyValueVO(String guarantyId,String value)
    {
        String update="update Guaranty set EvaluateValue =" +"'"+ value+"'"+" where guarantyId =" +"'"+guarantyId+"'";
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

    List<ReviewCompanyInfoVO> getCompanyStateUnapplied2pages(int page)
    {
        List<ReviewCompanyInfoVO> reviewCompanyInfoVOS=getCompanyStateUnapplied();
        List<ReviewCompanyInfoVO> pageInfo=new ArrayList<>();

            int maxpages = reviewCompanyInfoVOS.size() / 21 + 1;
            if (page > maxpages) {

            } else {
                if (page == maxpages) {
                    pageInfo= reviewCompanyInfoVOS.subList((page - 1) * 20, reviewCompanyInfoVOS.size());
                } else {
                    pageInfo= reviewCompanyInfoVOS.subList((page - 1) * 20, page * 20);
                }
            }
            return pageInfo;
        }



    List<ReviewChainInfoVO> getGuarantyTBCInfo2pages(String user_id_token,int page)
    {
        List<ReviewChainInfoVO> list=getGuarantyTBCInfo(user_id_token);
        List<ReviewChainInfoVO> pageInfo=new ArrayList<>();
        int maxpages = list.size() / 21 + 1;
        if (page > maxpages) {

        } else {
            if (page == maxpages) {
                pageInfo= list.subList((page - 1) * 20, list.size());
            } else {
                pageInfo=  list.subList((page - 1) * 20, page * 20);
            }
        }
        return pageInfo;
    }
    UpdateGuarantyValueVO updateCompanyState(String company_id)
    {
        String update="UPDATE Company SET Status ='checking_2' WHERE AccountNum='"+company_id+"'";
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
