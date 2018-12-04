package cn.kingstar.ch4redis.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.kingstar.ch4redis.domain.Book;
/**
 * @author wujinxing
 * @date: 2018/11/16 11:24
 * @description:
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
