package top.wujinxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wujinxing.dao.UserInfoDao;
import top.wujinxing.entity.UserInfo;
import top.wujinxing.service.UserInfoService;

import javax.annotation.Resource;

/**
 * @author: wujinxing
 * @date: 2019/4/10 11:28
 * @description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String name) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(name);
    }
}
