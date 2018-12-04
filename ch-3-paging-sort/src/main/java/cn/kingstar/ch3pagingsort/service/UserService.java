package cn.kingstar.ch3pagingsort.service;

import cn.kingstar.ch3pagingsort.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @auther: wujinxing
 * @date: 2018/11/13 21:49
 * @description:
 */
public interface UserService {
    /**
     * 获取用户分页列表
     *
     * @param pageable
     * @return
     */
    Page<User> findByPage(Pageable pageable);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    User insertByUser(User user);
}
