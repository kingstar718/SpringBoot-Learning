package top.wujinxing.ch15jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "top.wujinxing.ch15jpa.dao")
public class Ch15JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch15JpaApplication.class, args);
    }

}
