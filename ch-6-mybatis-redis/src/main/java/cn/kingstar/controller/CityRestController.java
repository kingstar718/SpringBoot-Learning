package cn.kingstar.controller;

import cn.kingstar.domain.City;
import cn.kingstar.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wujinxing
 * @date: 2018/11/21 10:42
 * @description:
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping
    public String hello(){
        return "mybait-redis";
    }

    @RequestMapping(value = "/api/city/{id}",method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id")Long id){
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "/api/city",method = RequestMethod.POST)
    public void createCity(@RequestBody City city){
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city",method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city){
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}",method = RequestMethod.DELETE)
    public void deleteCityById(@PathVariable("id")Long id){
        cityService.deleteCity(id);
    }
}
