package top.wujinxing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.wujinxing.pojo.User;

/**
 * @author wujinxing
 * date 2019 2019/10/19 21:23
 * description
 */
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}
