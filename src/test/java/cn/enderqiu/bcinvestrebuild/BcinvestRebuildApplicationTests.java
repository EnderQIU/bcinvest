package cn.enderqiu.bcinvestrebuild;

import cn.enderqiu.bcinvestrebuild.samples.SampleVO;
import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.enderqiu.bcinvestrebuild.util.MapExtracter;
//import com.sun.javafx.collections.MappingChange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BcinvestRebuildApplicationTests extends BaseService {

    @Test
    public void contextLoads() {

//        Map<String, Object> map = new HashMap<>();
//        map.put("SampleString", "testString");
//        map.put("SampleInt", 100);
//        SampleVO vo = new SampleVO();
//        try {
//            MapExtracter.extract(vo, map);
//        } catch (IntrospectionException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(vo.getSampleInt());
//        System.out.println(vo.getSampleString());

//        testEnum();

        testEmptyDatabase();

//        tryNewDataBase();

    }

    private void testEmptyDatabase() {
        List l = mapper.SELECT("SELECT * FROM credit");
        if (l == null)
            System.out.println("l is null");
        else
            System.out.println("length of l is zero");
    }

    private void tryNewDataBase() {
        mapper.INSERT("INSERT INTO Company (AccountNum, Status) VALUES ('123456456', 'passed');");
        showAllCompanyUser();
        mapper.UPDATE("UPDATE Company SET Credit = 100 WHERE Status = 'passed';");
        showAllCompanyUser();
        mapper.DELETE("DELETE FROM Company WHERE Status = 'passed';");
        showAllCompanyUser();
    }

    private void showAllCompanyUser() {
        List<Map<String, Object>> sl = mapper.SELECT("SELECT * FROM Company;");
        Logger logger = Logger.getLogger("CompanyUserServiceImpl.class");
        for (Map<String, Object> m:sl) {
            for (String key : m.keySet()) {
                logger.info("\t" + key + ": " + m.get(key));
            }
            logger.info("");
        }
    }
}
