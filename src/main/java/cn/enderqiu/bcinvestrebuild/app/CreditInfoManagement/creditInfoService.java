package cn.enderqiu.bcinvestrebuild.app.CreditInfoManagement;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.impls.CreditChainImpl;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class creditInfoService extends BaseService{
private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    public List<creditInfoVO> getCompanyCredit(String user_id_token)
    {
        CreditChainImpl creditChain=new CreditChainImpl();
        List<Map<String, Object>> mm = mapper.SELECT("Select * from Company where Token =" + user_id_token);
        if (mm.size() > 0) {
            String CompanyNum = mm.get(0).get("AccountNum").toString();

            List<creditInfoVO> cinfoList = new ArrayList<>();


            List<Map<String, Object>> creditinfo = creditChain.getCompanyCreditList(CompanyNum);

           cinfoList=getCompanyCreditList(CompanyNum);
            return cinfoList;
        }
        else
        {
            return null;
        }
        }




    public List<creditInfoVO> getCompanyCreditList(String CompanyNum)
    {
            CreditChainImpl creditChain=new CreditChainImpl();
            List<creditInfoVO> cinfoList = new ArrayList<>();


            List<Map<String, Object>> creditinfo = creditChain.getCompanyCreditList(CompanyNum);

            for (Map<String, Object> m : creditinfo) {
                String accountid = " ", reportId = " ", guarantyId = " ", type = " ", duetime = " ", guarantyName = " ",credit=" ",
                        variation=" ",name=" ";

                List<Map<String,Object>> mm=mapper.SELECT("select * from company where AccountNum = '"+CompanyNum+" '");
                name=mm.get(0).get("Name").toString();
                accountid = m.get("id").toString();
                credit=m.get("value").toString();
                variation=m.get("variation").toString();
                String date=m.get("remarks").toString().split("-")[0];
                duetime = simpleDateFormat.format(Long.valueOf(m.get("remarks").toString().split("-")[0]));
                type=m.get("remarks").toString().split("-")[1];
                creditInfoVO cinfo = new creditInfoVO(accountid, guarantyId, reportId, guarantyName, duetime,type, credit,variation,name);
                cinfoList.add(cinfo);
            }

            return cinfoList;
        }



    public  List<creditInfoVO> getCompanyCredit2Pages(String user_id_token, int pages)
    {

        List<creditInfoVO> creditInfoVOS=getCompanyCredit(user_id_token);
        int maxpages=creditInfoVOS.size()/21+1;
        if(pages>maxpages)
        {
            return null;
        }
        else
        {
            if(pages==maxpages)
            {
                return creditInfoVOS.subList((pages-1)*20,creditInfoVOS.size());
            }
            else
            {
                return creditInfoVOS.subList((pages-1)*20,pages*20);
            }
        }

    }



    public List<creditInfoVO> getComapanyCreditList2Pages(String accountNum,int pages)
    {
        List<creditInfoVO> creditInfoVOS=getCompanyCreditList(accountNum);
        int maxpages=creditInfoVOS.size()/21+1;
        if(pages>maxpages)
        {
            return null;
        }
        else
        {
            if(pages==maxpages)
            {
                return creditInfoVOS.subList((pages-1)*20,creditInfoVOS.size());
            }
            else
            {
                return creditInfoVOS.subList((pages-1)*20,pages*20);
            }
        }
    }



}
