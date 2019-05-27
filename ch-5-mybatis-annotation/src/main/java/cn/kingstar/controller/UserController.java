package cn.kingstar.controller;

import cn.kingstar.dao.UserMapper;
import cn.kingstar.domain.Page;
import cn.kingstar.domain.User;
import cn.kingstar.domain.UserParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/27 15:57
 * description
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        List<User> users = userMapper.getAll();
        return users;
    }

    //方法有误s
    @RequestMapping("/getList")
    public Page<User> getList(UserParam userParam){
        List<User> users = userMapper.getList(userParam);
        long count = userMapper.getCount(userParam);
        Page page = new Page(userParam, count, users);
        return page;
    }

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id")Long id){
        User user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")  //http://localhost:8080/add?userName=sasa&passWord=dasda&userSex=MAN&nickName=sasa
    public void save(User user){
        LOGGER.info("添加的用户为: " + user.toString());
        userMapper.insert(user);
    }

    @RequestMapping("/update")
    public void update(User user){
        userMapper.update(user);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userMapper.delete(id);
    }
}
