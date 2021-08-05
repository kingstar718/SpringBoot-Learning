package top.wujinxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
// 需要该注解开开启异步调用
@EnableAsync
public class Ch18AsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch18AsyncApplication.class, args);
    }
}
