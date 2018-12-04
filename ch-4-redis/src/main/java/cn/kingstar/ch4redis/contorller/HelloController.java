package cn.kingstar.ch4redis.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: wujinxing
 * @date: 2018/11/16 10:53
 * @description:
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String Hello(){
        return "Hello springboot and Redis";
    }
}
