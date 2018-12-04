package cn.kingstar.pagging.service;

import cn.kingstar.pagging.domain.User;

import java.util.List;

/**
 * @auther: wujinxing
 * @date: 2018/11/13 17:39
 * @description:
 */
public interface UserService {
    List<User> findAll();
    User insertByUser(User user);
    User update(User user);
    User delete(Long id);
    User findById(Long id);
}
