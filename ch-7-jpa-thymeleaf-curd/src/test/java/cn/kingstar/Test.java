package cn.kingstar;

import cn.kingstar.entity.User;
import cn.kingstar.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.jws.soap.SOAPBinding;

/**
 * @author: wujinxing
 * @date: 2018/11/21 21:28
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class Test {

    @Autowired
    private UserService userService;

    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @org.junit.Test
    public void test1(){
        User user= userService.findUserById(1);
        System.out.println(user.toString());
        User user1 = new User();
        user1.setAge(22);
        user1.setUserName("李哥");
        user1.setPassword("劫");
        userService.save(user1);
        //User user3= userService.findUserById(2);
        //System.out.println(user3.toString());
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }
}
