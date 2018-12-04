package cn.kingstar.ch7restful.dao;

import cn.kingstar.ch7restful.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2018/11/30 21:40
 * @description:
 */
public interface CityDao {
    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
