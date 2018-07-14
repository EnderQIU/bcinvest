package cn.enderqiu.bcinvestrebuild.mapper;

import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface BankUserMapper {
    @Select("select * from Authorization where Token=#{token}")
    @Results({
            @Result(property ="companyUserId",column="AccountNum"),
            @Result(property = "userName",column = "Name"),
            @Result(property = "userType",column = "Type"),
            @Result(property = "token",column = "Token")
    })
    BankUserDTO findUserByToken(String token);
}
