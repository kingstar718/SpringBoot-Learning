package cn.kingstar.service;

import cn.kingstar.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2018/11/18 21:26
 * @description:
 */
public interface CityService {
    /**
     * 根据城市名称,查询城市信息
     * @param cityName
     * @return
     */
    City findCityByName(String cityName);

    /**
     * 查询所有城市
     * @return
     */
    List<City> findAll();

    void insertCity(@Param("province") long provinceId, @Param("cityName") String cityName, @Param("description") String description);
}
