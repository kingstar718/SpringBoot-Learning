package cn.kingstar.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujinxing
 * date 2019 2019/4/30 16:17
 * description
 */
@RestController
@RequestMapping("/hello")
public class RolesController {

    @GetMapping
    public String getWelcomeMsg(){
        return "Hello, Spring Security";
    }

    @GetMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('admin')")  //开启方法级安全控制,指定该方法需要的角色
    public String helloAdmin(){
        return "Hello, Admin";
    }

    @GetMapping("/helloUser")
    @PreAuthorize("hasAnyRole('admin', 'normal')")
    public String helloUser(){
        return "Hello, User";
    }
}
