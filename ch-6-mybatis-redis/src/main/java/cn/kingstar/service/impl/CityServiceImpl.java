package cn.kingstar.service.impl;

import cn.kingstar.dao.CityMapper;
import cn.kingstar.domain.City;
import cn.kingstar.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: wujinxing
 * @date: 2018/11/21 10:28
 * @description:
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    @Override
    public City findCityById(Long id){
        //从缓存中获取城市信息
        String key = "city_"+id;
        ValueOperations<String,City> operations = redisTemplate.opsForValue();

        //缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            City city = operations.get(key);
            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }
        //从DB中获取城市
        City city = cityMapper.findById(id);

        //插入缓存
        operations.set(key,city,10,TimeUnit.SECONDS); //缓存的时间仅有十秒钟
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
        LOGGER.info("刚才加入redis的数据是： "+operations.get(key));
        return city;
    }

    @Override
    public Long saveCity(City city) {
        return cityMapper.saveCity(city);
    }

    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    @Override
    public Long updateCity(City city) {
        Long ret = cityMapper.updateCity(city);

        //缓存存在,删除缓存
        String key = "city_" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey){
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }
        return ret;
    }

    @Override
    public Long deleteCity(Long id) {
        Long ret = cityMapper.deleteCity(id);

        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }

        return ret;
    }
}
