package cn.kingstar.dao;

import cn.kingstar.entity.SysUser;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    public SysUser findByUserName(String username);
}
