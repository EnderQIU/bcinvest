package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement;

import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.Entity.VO.CompanyCreditInfoVO;
import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.Entity.VO.CompanyInfoDetailVO;
import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.Entity.VO.CompanyInfoVO;
import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.Entity.VO.GuarantyInfoVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by EvanChoo on 7/14/18.
 */

@Service
public class CompanyInfoService {
    public List<CompanyInfoVO> getAllCompanyInfo() {
        //todo: implement this
        return null;
    }

    public List<CompanyInfoVO> getSearchCompanyResult(String accountNum, String name, String telName, String email) {
        //todo: implement this
        return null;
    }

    public CompanyInfoDetailVO getCompanyDetail(String accountNum) {
        //todo: implement this
        return null;
    }

    public CompanyCreditInfoVO getCreditInfo(String accountNum) {
        //todo: implement this
        return null;
    }

    public List<GuarantyInfoVO> getAllGuaranty(String accountNum) {
        //todo: implement this
        return null;
    }

    public BaseResponseVO cancleCompanyAccount(String accountNum) {
        //todo: implement this
        return null;
    }
}
