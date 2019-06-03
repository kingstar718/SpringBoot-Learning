package top.wujinxing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.wujinxing.pojo.User;

/**
 * @author wujinxing
 * date 2019 2019/6/3 17:03
 * description
 */
@Controller
@RequestMapping("/data")
public class ModelController {

    //测试视图
    @GetMapping("/model")
    public String useModel(Long id, Model model){
        User user = new User((long) 1, "乐哥", 23);
        if (user.getId().equals(id)){
            model.addAttribute("user", user);
        }else {
            User user1 = new User((long) 2, "新建", 23);
            model.addAttribute("user", user1);
        }
        return "user";
    }
}
