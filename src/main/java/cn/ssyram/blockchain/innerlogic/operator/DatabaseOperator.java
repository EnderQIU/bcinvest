package cn.ssyram.blockchain.innerlogic.operator;

import cn.enderqiu.bcinvestrebuild.mapper.Mapper;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * 对本数据库的操作只可能是查和增
 */
@Component
public class DatabaseOperator {
//    @Autowired
    public static Mapper mapper;

    @Autowired
    public void setMapper(Mapper mapper) {
        DatabaseOperator.mapper = mapper;
    }

//    @Autowired(required = true)
//    private Mapper map;
//    public static DatabaseOperator operator = new DatabaseOperator();
    
//    static {
//        try {
//            Reader reader = org.apache.ibatis.io.Resources.getResourceAsReader("mybatis-config" +
//                    ".xml");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
//            SqlSession session = factory.openSession();
//            mapper = session.getMapper(Mapper.class);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static Mapper getMapper() {
        return mapper;
    }

//    private static DatabaseOperator operator;
//
//    @PostConstruct
//    public void init() {
//        operator = this;
//    }

//    @Autowired(required = true)
//    public static void setMapper(Mapper mapper) {
//        DatabaseOperator.mapper = mapper;
//    }

    public static List<Map<String, Object>> SELECT(String sentence) {
        return getMapper().SELECT(sentence);
    }
    public static int INSERT(String sentence) {
        return getMapper().INSERT(sentence);
    }
    public static int UPDATE(String sentence) {
        return getMapper().UPDATE(sentence);
    }
}
