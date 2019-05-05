package cn.kingstar.service;

import cn.kingstar.dao.UserInfoRepsository;
import cn.kingstar.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wujinxing
 * date 2019 2019/4/30 16:39
 * description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepsository userInfoRepsository;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepsository.findByUsername(username);
    }
}
