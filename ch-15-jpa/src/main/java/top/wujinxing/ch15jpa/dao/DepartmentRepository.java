package top.wujinxing.ch15jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.wujinxing.ch15jpa.entity.Department;

/**
 * @author wujinxing
 * date 2019 2019/5/20 10:05
 * description
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
