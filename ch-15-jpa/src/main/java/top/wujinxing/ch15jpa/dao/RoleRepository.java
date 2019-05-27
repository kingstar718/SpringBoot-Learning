package top.wujinxing.ch15jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import top.wujinxing.ch15jpa.entity.Role;

/**
 * @author wujinxing
 * date 2019 2019/5/20 10:18
 * description
 */
@Repository
@Component
public interface RoleRepository extends JpaRepository<Role, Long> {
}
