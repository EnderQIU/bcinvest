package cn.enderqiu.bcinvestrebuild.service.impl;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.service.contract.BankUserService;
import org.springframework.stereotype.Service;

@Service
public class BankUserServiceImpl implements BankUserService {

    @Override
    public BankUserDTO findUserByToken(String token) {
        return null;
    }
}
