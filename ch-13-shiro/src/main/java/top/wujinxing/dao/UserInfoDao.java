package top.wujinxing.dao;

import org.springframework.data.repository.CrudRepository;
import top.wujinxing.entity.UserInfo;

/**
 * @author: wujinxing
 * @date: 2019/4/10 11:26
 * @description:
 */
public interface UserInfoDao extends CrudRepository<UserInfo, Long> {

    /**
     * 通过username查询用户
     * @param name
     * @return
     */
    public UserInfo findByUsername(String name);
}
