package cn.kingstar.controller;

import cn.kingstar.domain.City;
import cn.kingstar.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wujinxing
 * @date: 2018/11/18 21:31
 * @description:
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Hello(){
        return "Hello World!";
    }

    @RequestMapping(value = "/api/city",method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName",required = true) String cityName){
        return cityService.findCityByName(cityName);
    }
}
