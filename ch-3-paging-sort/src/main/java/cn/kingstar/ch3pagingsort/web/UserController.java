package cn.kingstar.ch3pagingsort.web;

import cn.kingstar.ch3pagingsort.domain.User;
import cn.kingstar.ch3pagingsort.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: wujinxing
 * @date: 2018/11/13 21:16
 * @description:
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {



    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello")
    public String Start(){
        return "页面排序aaaa";
    }

    /**
     *  获取用户分页列表
     *    处理 "/users" 的 GET 请求，用来获取用户分页列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     *
     *    Pageable 支持的分页参数如下
     *    page - 当前页 从 0 开始
     *    size - 每页大小 默认值在 application.properties 配置
     */
    @RequestMapping(method = RequestMethod.GET)
    public Page<User> getUserPage(Pageable pageable){
        return userService.findByPage(pageable);
    }

    /**
     *  创建用户
     *    处理 "/users" 的 POST 请求，用来获取用户列表
     *    通过 @RequestBody 绑定实体类参数
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public User postUser(@RequestBody User user){
        return userService.insertByUser(user);
    }
}
