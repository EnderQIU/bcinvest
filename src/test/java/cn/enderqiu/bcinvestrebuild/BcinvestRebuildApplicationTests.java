package cn.enderqiu.bcinvestrebuild;

import cn.enderqiu.bcinvestrebuild.service.BaseService;
import cn.ssyram.blockchain.GlobalInfo;
import cn.ssyram.blockchain.impls.GurantyChainImpl;
import cn.ssyram.blockchain.innerlogic.Dispatcher;
import cn.ssyram.blockchain.interfaces.GuarantyChain;
import com.generator.tables.Guaranty;
import org.jooq.util.derby.sys.Sys;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

//import com.sun.javafx.collections.MappingChange;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BcinvestRebuildApplicationTests extends BaseService {

    private void outputLine(String line) {
        System.out.println(line);
    }

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

//        testEmptyDatabase();

//        tryNewDataBase();

        tryBlockChain();
    }

    private void tryBlockChain() {
        Dispatcher.startMining(GlobalInfo.MINING_WAIT_TIME);
//        outputLine(GuarantyChain.chain.getGuarantyState(123).toString());
        GuarantyChain.chain.deleteGuaranty(456);
        Object monitor = new Object();
        synchronized (monitor) {
            try {
                monitor.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        outputLine(GuarantyChain.chain.getGuarantyState(456).toString());
//        GuarantyChain.chain.updateGuarantyState(123, 1);
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
