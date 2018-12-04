package cn.kingstar.ch3pagingsort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.kingstar.*"})
public class Ch3PagingSortApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch3PagingSortApplication.class, args);
    }
}
