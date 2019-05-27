package cn.kingstar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.kingstar.dao")
public class Ch5MybatisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch5MybatisAnnotationApplication.class, args);
    }
}
