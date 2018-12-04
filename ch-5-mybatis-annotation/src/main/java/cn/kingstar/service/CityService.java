package cn.kingstar.service;

import cn.kingstar.domain.City;

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
}
