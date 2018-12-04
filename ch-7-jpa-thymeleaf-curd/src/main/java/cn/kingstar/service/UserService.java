package cn.kingstar.service;

import cn.kingstar.entity.User;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2018/11/21 18:54
 * @description:
 */
public interface UserService {
    public List<User> getUserList();
    public User findUserById(long id);
    public void save(User user);
    public void edit(User user);
    public void delete(long id);

}
