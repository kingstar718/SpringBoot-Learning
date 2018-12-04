package cn.kingstar.dao;

import cn.kingstar.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "cityMapper")
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    List<City> findAllCity();
    City findById(@Param("id") Long id);
    Long saveCity(City city);
    Long updateCity(City city);
    Long deleteCity(Long id);
}