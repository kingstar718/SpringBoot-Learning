package cn.kingstar;

import cn.kingstar.entity.User;
import cn.kingstar.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ch7CuedJpaThymeleafApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {

        User user = new User();
        user.setPassword("wewew");
        user.setUserName("lige");
        user.setAge(11);

        userService.save(user);
        List<User> user1 = userService.getUserList();
        System.out.println(user1.toString());
    }

}
