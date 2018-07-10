package cn.enderqiu.bcinvestrebuild;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.enderqiu.bcinvestrebuild.mapper")
public class BcinvestRebuildApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcinvestRebuildApplication.class, args);
    }
}
