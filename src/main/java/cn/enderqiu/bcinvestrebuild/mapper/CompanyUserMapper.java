package cn.enderqiu.bcinvestrebuild.mapper;

import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.TokenResponseVO;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

public interface CompanyUserMapper {
    @Select("select * from CompanyUser where token=#{token}")
    @Results({
            @Result(property ="companyUserId",column="CompanyUserId"),
            @Result(property = "userName",column = "LocalName"),
            @Result(property = "status",column = "Status"),
            @Result(property = "token",column = "Token")
    })
    CompanyUserDTO findUserByToken(String token);

    @Select("select token from CompanyUser where EmailAddress=#{onlyEmail}")
    @Results({@Result(property = "token", column = "Token")})
    TokenResponseVO findTokenByOnlyEmail(String onlyEmail);

    @Insert("INSERT INTO CompanyUser (EmailAddress, Token, Status) VALUES (#{onlyEmail}, " +
            "#{token}, 0)")
    int createUserByTokenAndEmail(@Param("token") String token, @Param("onlyEmail") String
            onlyEmail);

    @Update("UPDATE CompanyUser SET UserName = #{userName} WHERE Token = #{token}")
    int changeUserNameByToken(@Param("token") String token, @Param("userName") String userName);

    @Update("UPDATE CompanyUser SET TelephoneNumber = #{telephoneNumber} WHERE Token = #{token}")
    int changeTeleNumByToken(@Param("token") String token, @Param("telephoneNumber") String
            telephoneNumber);

    @Update("UPDATE CompanyUser SET Status = #{status} WHERE Token = #{token}")
    int changeStatusByToken(@Param("token") String token, @Param("status") int status);

//    @Select("${sentence}")
//    @ResultType(java.util.HashMap.class)
//    List<Map<String,Object>> tryGetAllBySentence(@Param("sentence")String sentence);
}
