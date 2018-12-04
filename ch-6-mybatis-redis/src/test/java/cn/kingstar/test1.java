package cn.kingstar;

import cn.kingstar.domain.City;
import cn.kingstar.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: wujinxing
 * @date: 2018/11/21 11:04
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class test1 {

    @Autowired
    private CityService cityService;

    @Test
    public void test() throws Exception{
        Long id;
        id = Long.valueOf(1);
        City city = cityService.findCityById(id);
        System.out.println(city.toString());
    }
}
