package cn.kingstar.dao;

import cn.kingstar.domain.City;
import org.apache.ibatis.annotations.*;

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
    @Select("SELECT * FROM city")
    //返回map结果集
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    City findByName(@Param("cityName") String cityName);
}
