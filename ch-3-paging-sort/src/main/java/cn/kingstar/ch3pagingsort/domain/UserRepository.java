package cn.kingstar.ch3pagingsort.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @auther: wujinxing
 * @date: 2018/11/13 21:30
 * @description:
 */
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
