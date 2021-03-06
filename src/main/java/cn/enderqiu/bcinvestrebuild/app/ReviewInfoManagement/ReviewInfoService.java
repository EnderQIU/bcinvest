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

        List<Map<String,Object>> mm=mapper.SELECT("Select * from Company where AccountNum ="+"'"+company_id+"'");
        if(mm.size()>0) {

            String CompanytNum = mm.get(0).get("AccountNum").toString();
            String telNum="";
            String emailAddress="";
            String Name = mm.get(0).get("Name").toString();
            if(mm.get(0).get("TelNum")!=null) {
                telNum = mm.get(0).get("TelNum").toString();
            }
            if(mm.get(0).get("EmailAddress")!=null) {
                emailAddress = mm.get(0).get("EmailAddress").toString();
            }
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
//        List<Map<String, Object>> bankUser = mapper.SELECT("Select * from Authorization where Token =" +"'" +user_id_token+"'");
//        List<Map<String,Object>> m=mapper.SELECT("Select g.AccountNum as CompanyId,r.ReportId,a.AccountNum as AuthorityId," +
//                "g.Name,g.EvaluateValue,g.guarantyId"+
//                " from Guaranty g,Report r,Authorization a where g.Type = 1 and r.reportId= g.reportId and r.AccountNum = a.AccountNum " +
//                "and a.AccountNum ="+"'"+
//        bankUser.get(0).get("AccountNum")+"'");
        List<Map<String,Object>> m=mapper.SELECT("Select * from Guaranty where EvaluateValue is Null ");
        if(m.size()>0) {
            for (Map<String, Object> mm : m) {

                ReviewCompanyInfoVO reviewCompanyInfoVO = getCompanyInfo(mm.get("AccountNum").toString());

                String guarantyName = mm.get("Name").toString();
                String guarantyId = mm.get("GuarantyId").toString();
                String type=mm.get("State").toString();


                ReviewChainInfoVO reviewChainInfoVO = new ReviewChainInfoVO(reviewCompanyInfoVO, guarantyId, guarantyName,type);
                guarantyTBCinfos.add(reviewChainInfoVO);
            }

        }
        return guarantyTBCinfos;

    }
    UpdateGuarantyValueVO updateGuarantyValueVO(String guarantyId,String value)
    {
        String update="update Guaranty set EvaluateValue =" +"'"+ value+"'"+" where guarantyId =" +"'"+guarantyId+"'";
        int m=mapper.UPDATE(update);
        int n=mapper.UPDATE("update Guaranty set State = '2' "+" where guarantyId =" +"'"+guarantyId+"'");
        if(m==1&&n==1)
        {
            return new UpdateGuarantyValueVO("success");

        }
        else
        {
            return new UpdateGuarantyValueVO("error");
        }

    }

    List<ReviewCompanyInfoVO> getCompanyStateUnapplied2pages(int page)
    {
        List<ReviewCompanyInfoVO> reviewCompanyInfoVOS=getCompanyStateUnapplied();
        List<ReviewCompanyInfoVO> pageInfo=new ArrayList<>();

            int maxpages = reviewCompanyInfoVOS.size() / 11 + 1;
            if (page > maxpages) {

            } else {
                if (page == maxpages) {
                    pageInfo= reviewCompanyInfoVOS.subList((page - 1) * 10, reviewCompanyInfoVOS.size());
                } else {
                    pageInfo= reviewCompanyInfoVOS.subList((page - 1) * 10, page * 10);
                }
            }
            return pageInfo;
        }



    List<ReviewChainInfoVO> getGuarantyTBCInfo2pages(String user_id_token,int page)
    {
        List<ReviewChainInfoVO> list=getGuarantyTBCInfo(user_id_token);
        List<ReviewChainInfoVO> pageInfo=new ArrayList<>();
        int maxpages = list.size() / 11 + 1;
        if (page > maxpages) {

        } else {
            if (page == maxpages) {
                pageInfo= list.subList((page - 1) * 10, list.size());
            } else {
                pageInfo=  list.subList((page - 1) * 10, page * 10);
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
