package cn.kingstar.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: wujinxing
 * @date: 2018/11/21 21:19
 * @description:
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name){
        model.addAttribute("name",name);
        return "hello";
    }
}
