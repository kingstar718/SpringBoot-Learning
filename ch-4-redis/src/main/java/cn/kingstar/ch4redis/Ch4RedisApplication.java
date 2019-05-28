package cn.kingstar.ch4redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  //开启缓存
public class Ch4RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch4RedisApplication.class, args);
    }
}
