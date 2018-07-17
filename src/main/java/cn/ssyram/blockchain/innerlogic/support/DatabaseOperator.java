package cn.ssyram.blockchain.innerlogic.support;

import cn.enderqiu.bcinvestrebuild.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 对本数据库的操作只可能是查和增
 */
@Component
public class DatabaseOperator {
    @Autowired
    private static Mapper mapper;

    public static List<Map<String, Object>> SELECT(String sentence) {
        return mapper.SELECT(sentence);
    }
    public static int INSERT(String sentence) {
        return mapper.INSERT(sentence);
    }
    public static int UPDATE(String sentence) {
        return mapper.UPDATE(sentence);
    }
}
