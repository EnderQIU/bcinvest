package cn.enderqiu.bcinvestrebuild.service;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.mapper.BankUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankUserService {

    @Autowired
    private BankUserMapper bankUserMapper;

    public BankUserDTO findUserByToken(String token) {
        BankUserDTO bankUserDTO = bankUserMapper.findUserByToken(token);
        return bankUserDTO;
    }
}
