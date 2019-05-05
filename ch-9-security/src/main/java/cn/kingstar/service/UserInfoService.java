package cn.kingstar.service;

import cn.kingstar.entity.UserInfo;

/**
 * @author wujinxing
 * date 2019 2019/4/30 16:39
 * description
 */
public interface UserInfoService {
    public UserInfo findByUsername(String username);
}
