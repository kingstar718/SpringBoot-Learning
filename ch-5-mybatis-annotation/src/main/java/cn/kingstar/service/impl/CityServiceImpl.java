package cn.kingstar.service.impl;

import cn.kingstar.dao.CityDao;
import cn.kingstar.domain.City;
import cn.kingstar.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author: wujinxing
 * @date: 2018/11/18 21:27
 * @description:
 */
@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public void insertCity(long provinceId, String cityName, String description) {
        cityDao.insertCity(provinceId, cityName, description);
    }
}
