package cn.kingstar.service;

import cn.kingstar.domain.City;

/**
 * @author: wujinxing
 * @date: 2018/11/21 10:26
 * @description:
 */
public interface CityService {
    City findCityById(Long id);
    Long saveCity(City city);
    Long updateCity(City city);
    Long deleteCity(Long id);
}
