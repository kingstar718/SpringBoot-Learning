package top.wujinxing.ch14buygoods;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author wujinxing
 * date 2019 2019/5/14 11:07
 * description
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Ch14BuygoodsApplication.class);
    }
}
