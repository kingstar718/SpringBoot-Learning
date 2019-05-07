package cn.kingstar.controller;

import cn.kingstar.domain.City;
import cn.kingstar.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/findAllCity")
    public List<City> findAll(){
        return cityService.findAll();
    }

    @PostMapping("/api/insertCity")
    public String insertCity(@PathVariable long provinceId,
                             @PathVariable String cityName,
                             @PathVariable String description){
        cityService.insertCity(provinceId, cityName, description);
        return "OK";
    }
}
