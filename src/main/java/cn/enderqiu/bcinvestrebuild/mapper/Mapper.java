package cn.enderqiu.bcinvestrebuild.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Mapper {
    /**
     * 执行SELECT语句
     * @param sentence：需要执行的SQL语句
     * @return 返回值就是一个List<Map<String, Object>>，一个Map<String, Object>是一个对应的行，里面的键就是列名，值的Object就是对应行的对应列的值。
     */
    @Select("${sentence}")
    @ResultType(java.util.HashMap.class)
    List<Map<String, Object>> SELECT(@Param("sentence")String sentence);

    @Insert("${sentence}")
    int INSERT(@Param("sentence")String sentence);

    @Update("${sentence}")
    int UPDATE(@Param("sentence")String sentence);

    @Delete("${sentence}")
    int DELETE(@Param("sentence")String sentence);
}
