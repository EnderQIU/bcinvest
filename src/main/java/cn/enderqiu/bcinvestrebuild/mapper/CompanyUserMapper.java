package cn.enderqiu.bcinvestrebuild.mapper;

import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.TokenResponseVO;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

public interface CompanyUserMapper {
    @Select("select * from Company where Token=#{token}")
    @Results({
            @Result(property ="companyUserId",column="AccountNum"),
            @Result(property = "userName",column = "Name"),
            @Result(property = "status",column = "Status"),
            @Result(property = "token",column = "Token")
    })
    CompanyUserDTO findUserByToken(@Param("token") String token);

    @Select("SELECT Token FROM Company WHERE EmailAddress = #{onlyEmail}")
    @Results({@Result(property = "token", column = "Token")})
    TokenResponseVO findTokenByOnlyEmail(String onlyEmail);

    @Insert("INSERT INTO Company (EmailAddress, Token, Status) VALUES (#{onlyEmail}, " +
            "#{token}, 0)")
    int createUserByTokenAndEmail(@Param("token") String token, @Param("onlyEmail") String
            onlyEmail);

    @Update("UPDATE Company SET Name = #{userName} WHERE Token = #{token}")
    int changeUserNameByToken(@Param("token") String token, @Param("userName") String userName);

    @Update("UPDATE Company SET TelNum = #{telephoneNumber} WHERE Token = #{token}")
    int changeTelNumByToken(@Param("token") String token, @Param("telephoneNumber") String
            telephoneNumber);

    @Update("UPDATE Company SET Status = #{status} WHERE Token = #{token}")
    int changeStatusByToken(@Param("token") String token, @Param("status") int status);

//    @Select("${sentence}")
//    @ResultType(java.util.HashMap.class)
//    List<Map<String,Object>> tryGetAllBySentence(@Param("sentence")String sentence);
}
