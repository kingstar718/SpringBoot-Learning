package top.wujinxing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.pojo.User;

/**
 * @author wujinxing
 * date 2019 2019/6/3 16:13
 * description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/add")
    public String add(){
        return "user";
    }

    //使用Json传递参数
    @PostMapping("/insert")
    @ResponseBody  //返回json
    public User insert(@RequestBody User user){//接受json
        LOGGER.info("返回的是Json : " + user.toString());
        return user;
    }

    //通过URL传递参数  使用PathVariable
    @GetMapping("/{id}")
    @ResponseBody
    public User url(@PathVariable("id") Long id){
        User user1 = new User((long) 1,"乐哥1",23);
        User user2 = new User((long) 2,"乐哥2",23);
        if (user1.getId().equals(id)){
            return user1;
        }else if (user2.getId().equals(id)){
            return user2;
        }else {
            return null;
        }
    }
}
