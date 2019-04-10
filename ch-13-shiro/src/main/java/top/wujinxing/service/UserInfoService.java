package top.wujinxing.service;

import org.springframework.stereotype.Service;
import top.wujinxing.entity.UserInfo;

/**
 * @author: wujinxing
 * @date: 2019/4/10 11:27
 * @description:
 */
@Service
public interface UserInfoService {
    /**
     * 通过username查询用户
     * @param name
     * @return
     */
    public UserInfo findByUsername(String name);
}
