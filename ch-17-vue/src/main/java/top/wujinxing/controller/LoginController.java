package top.wujinxing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import top.wujinxing.pojo.User;
import top.wujinxing.result.Result;
import top.wujinxing.service.UserService;

import java.util.Objects;

/**
 * @author wujinxing
 * date 2019 2019/10/19 19:59
 * description
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping()
    public String hello(){
        return "hello";
    }

    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        System.out.println("登陆的账号为：" + username + " ,密码为：" + requestUser.getPassword());
        /*if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }*/

        //数据库拿出
        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            System.out.println("验证失败");
            return new Result(400);
        }else {
            System.out.println("验证成功");
            return new Result(200);
        }
    }
}
