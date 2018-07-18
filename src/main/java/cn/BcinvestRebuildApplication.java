package cn;

import cn.ssyram.blockchain.innerlogic.Dispatcher;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("cn.enderqiu.bcinvestrebuild.mapper")
@ServletComponentScan
@EnableScheduling
public class BcinvestRebuildApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcinvestRebuildApplication.class, args);
        Dispatcher.startMining(0.001);
    }
}
