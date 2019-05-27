package top.wujinxing.ch15jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import top.wujinxing.ch15jpa.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/20 10:04
 * description
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNameLike(String name);
    User readByName(String name);
    List<User> getByCreatedateLessThan(Date start);
}
