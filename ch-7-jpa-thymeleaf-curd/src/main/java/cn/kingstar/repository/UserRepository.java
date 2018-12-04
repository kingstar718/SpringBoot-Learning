package cn.kingstar.repository;

import cn.kingstar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author: wujinxing
 * @date: 2018/11/21 17:53
 * @description:
 */
@Component(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User>,Serializable {


    User findById(long id);

    Long deleteById(long id);
}
