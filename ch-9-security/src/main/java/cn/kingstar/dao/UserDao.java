package cn.kingstar.dao;

import cn.kingstar.entity.SysUser;

public interface UserDao {
    public SysUser findByUserName(String username);
}
