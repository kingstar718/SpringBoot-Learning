package cn.kingstar.ch4redis.Service;

import cn.kingstar.ch4redis.domain.Book;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2018/11/16 11:28
 * @description:
 */
public interface BookService {
    /**
     * 获取所有book
     * @return
     */
    List<Book> findAll();

    /**
     * 新增book
     * @param book
     * @return
     */
    Book insertByBook(Book book);

    /**
     * 更新book
     * @param book
     * @return
     */
    Book update(Book book);

    /**
     * 删除book
     * @param id
     * @return
     */
    Book delete(Long id);

    /**
     * 获取book
     * @param id
     * @return
     */
    Book findById(Long id);

}
