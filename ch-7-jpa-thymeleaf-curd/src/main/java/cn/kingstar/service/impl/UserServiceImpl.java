package cn.kingstar.service.impl;

import cn.kingstar.entity.User;
import cn.kingstar.repository.UserRepository;
import cn.kingstar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2018/11/21 19:07
 * @description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
