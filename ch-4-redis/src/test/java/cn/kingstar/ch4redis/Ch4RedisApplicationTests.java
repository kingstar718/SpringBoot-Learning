package cn.kingstar.ch4redis;

import cn.kingstar.ch4redis.domain.Book;
import net.minidev.json.JSONUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ch4RedisApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("wu", "jinxing");

        Assert.assertEquals("jinxing", redisTemplate.opsForValue().get("wu"));
    }

    @Test
    public void testObj(){
        /*List<Book> list = new ArrayList<>();
        for (int i=0; i<10; i++){
            Book book = new Book();
            book.setId((long) i);
            book.setName("测试_"+i);
            book.setWriter("李哥_"+i);
            book.setIntroduction("介绍_"+i);
            list.add(book);
        }*/

    }

    /*@Bean(name="redisTemplate")
    public RedisTemplate<Object, Object> initRedisTemplate(){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer stringRedisSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        return redisTemplate;  //主动将 Redis 的键和散列结构的 field 和 value 均采用 了字符串序列化器，
    }*/

    @Test
    public void findTest(){
        //如何存储数据
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForHash().put("hash", "field", "h_value");


    }

    @Test
    public void optTest(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        String s = (String) hashOperations.get("hash", "field");
        System.out.println(s);
    }
}
