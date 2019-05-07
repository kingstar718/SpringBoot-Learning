package cn.kingstar.dao;

import cn.kingstar.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: wujinxing
 * @date: 2018/11/18 21:23
 * @description:
 */
@Mapper
public interface CityDao {
    /**
     * 根据城市名,查询城市信息
     * @param cityName
     * @return
     */
    @Select("SELECT * FROM city where city_name = #{cityName}")
    //返回map结果集
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findByName(@Param("cityName") String cityName);

    /**
     * 查询所有
     * @return
     */
    @Select("SELECT * FROM city")
    List<City> findAll();

    @Insert("INSERT INTO city(province_id, city_name, description) VALUES(#{provinceId}, #{cityName}, #{description})")
    void insertCity(@Param("provinceId") Long provinceId, @Param("cityName") String cityName, @Param("description") String description);
}
