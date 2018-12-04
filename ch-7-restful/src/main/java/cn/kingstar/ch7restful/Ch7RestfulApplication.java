package cn.kingstar.ch7restful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("cn.kingstar.ch7restful.dao")
public class Ch7RestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch7RestfulApplication.class, args);
    }
}
