package top.wujinxing.ch14buygoods;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "top.wujinxing.ch14buygoods")
@MapperScan(annotationClass = Mapper.class,
        basePackages = "top.wujinxing.ch14buygoods.mapper")
public class Ch14BuygoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch14BuygoodsApplication.class, args);
    }

}
