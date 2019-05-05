package cn.kingstar.config;

import cn.kingstar.dao.UserInfoRepsository;
import cn.kingstar.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author wujinxing
 * date 2019 2019/4/30 17:04
 * description
 */
@Service
public class DataInit {

    @Autowired
    UserInfoRepsository userInfoRepsository;

    @PostConstruct
    public void dataInit(){
        UserInfo admin = new UserInfo();
        admin.setUsername("admin");
        admin.setPassword("123");
        admin.setRole(UserInfo.Role.admin);
        userInfoRepsository.save(admin);

        UserInfo user = new UserInfo();
        admin.setUsername("user");
        admin.setPassword("123");
        admin.setRole(UserInfo.Role.normal);
        userInfoRepsository.save(user);
    }
}
