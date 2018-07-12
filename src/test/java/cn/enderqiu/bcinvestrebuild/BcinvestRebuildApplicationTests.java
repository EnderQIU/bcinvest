package cn.enderqiu.bcinvestrebuild;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BcinvestRebuildApplicationTests extends BaseService {

    @Test
    public void contextLoads() {

//        testEnum();

        tryNewDataBase();

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
