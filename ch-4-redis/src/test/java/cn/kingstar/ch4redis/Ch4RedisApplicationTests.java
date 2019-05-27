package cn.kingstar.ch4redis;

import cn.kingstar.ch4redis.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Ch4RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("wu", "jinxing");
        Assert.assertEquals("jinxing", redisTemplate.opsForValue().get("wu"));
    }

    @Test
    public void testObj(){
        Book book = new Book("李哥", "sjide","sasa");
        ValueOperations<String, Book> operations = redisTemplate.opsForValue();
        operations.set("top.wujinxing", book);
        Book b = operations.get("top.wujinxing");
        System.out.println("Book: " + b.toString());
    }
}
