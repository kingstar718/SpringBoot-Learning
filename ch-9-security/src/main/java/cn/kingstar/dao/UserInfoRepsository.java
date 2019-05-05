package cn.kingstar.dao;

import cn.kingstar.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wujinxing
 * date 2019 2019/4/30 16:37
 * description
 */
public interface UserInfoRepsository extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);
}
