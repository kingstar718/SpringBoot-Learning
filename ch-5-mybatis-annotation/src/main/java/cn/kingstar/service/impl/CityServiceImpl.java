package cn.kingstar.service.impl;

import cn.kingstar.dao.CityDao;
import cn.kingstar.domain.City;
import cn.kingstar.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: wujinxing
 * @date: 2018/11/18 21:27
 * @description:
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
}
