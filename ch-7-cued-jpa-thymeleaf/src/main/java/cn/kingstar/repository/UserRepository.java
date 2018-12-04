package cn.kingstar.repository;

import cn.kingstar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @author: wujinxing
 * @date: 2018/12/4 21:34
 * @description:
 */
public interface UserRepository extends JpaRepository<User,Long>,Serializable {

    User findById(long id);

    void deleteById(Long id);
}
