package top.wujinxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.wujinxing.User;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/11 17:37
 * @description:
 */
@Controller
@RequestMapping
public class HelloController {

    private List<User> getUserList(){
        List<User> list = new ArrayList<>();
        User user1 = new User("wujinxing","123456",12);
        User user2 = new User("Faker","SKT T1",22);
        User user3 = new User("Uzi","RNG",20);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }

    @RequestMapping("/")
    public String name(Model model, HttpServletRequest request){
        String name = "wujinxing";
        model.addAttribute("name",name);
        model.addAttribute("message","www.wujinxing.top");
        model.addAttribute("flag","yes");
        model.addAttribute("users",getUserList());
        model.addAttribute("type","link");
        model.addAttribute("pageId","springcloud/2017/09/11/");
        model.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");

        //request session
        request.setAttribute("request","I am request");
        request.getSession().setAttribute("session","I am session");
        return "hello";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
