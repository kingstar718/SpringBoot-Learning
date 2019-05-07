package cn.kingstar;

import cn.kingstar.dao.CityDao;
import cn.kingstar.domain.City;
import cn.kingstar.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ch5MybatisAnnotationApplicationTests {


    @Autowired
    private CityService cityService;

    @Autowired
    private CityDao cityDao;


    @Test
    public void test1(){
        //System.out.println(cityService.findCityByName("sss"));
        /*List<City> list = cityDao.findAll();
        for (City c: list
             ) {
            System.out.println(c);
        }*/
        cityDao.insertCity(10l, "武汉市", "湖北省武汉市");
    }


}
