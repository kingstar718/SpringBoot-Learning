package cn.kingstar.ch4redis.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/5/28 11:29
 * description
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash(){
        redisTemplate.opsForValue().set("key1", "value1");
        //注意这里使用了 JDK 的序列化器 ,所以 Redis 保存时不是整数, 不能运算
        redisTemplate.opsForValue().set("int_key", "1");
        stringRedisTemplate.opsForValue().set("int", "1");
        //使用运算
        stringRedisTemplate.opsForValue().increment("int", 1);

        Map<String, Object> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash2", hash);  //将Hashmap存储到redis中
        stringRedisTemplate.opsForHash().put("hash2", "field3", "value3");

        //绑定散列操作的 key,这样可以连续对同一个散列数据类型进行操作
        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash2");
        hashOps.delete("field2", "field1"); //删除元素
        hashOps.put("field4", "value4"); //添加元素
        //LOGGER.info(hashOps.entries().toString());
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> testList(){
        //链表从左到右的顺序为v10, v8, v6, v4, v2
        stringRedisTemplate.opsForList().leftPushAll("list1", "v2","v4","v6","v8","v10");
        //链表从左到右的顺序为v1, v3, v5, v7, v9
        stringRedisTemplate.opsForList().rightPushAll("list2", "v1","v3","v5","v7","v9");

        //绑定list2操作链表
        BoundListOperations listOps = stringRedisTemplate.boundListOps("list2");
        Object result1 = listOps.rightPop();//从右边弹出一个成员
        LOGGER.info("list2的最右边元素为: "+result1.toString());

        Object result2 = listOps.index(1); //获取定位元素, 下标从0开始
        LOGGER.info("list2下标为1的元素为"+result2.toString());

        listOps.leftPush("v0"); //从左边插入链表

        Long size = listOps.size();//求链表长
        LOGGER.info("list2的长度为: "+size);

        List element = listOps.range(0, size-2); //求链表区间成员
        LOGGER.info("list2从0到size-2的元素依次为: "+element.toString());

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/set")
    @ResponseBody
    public Map<String, Object> testSet(){
        //重复的元素不会被插入
        stringRedisTemplate.opsForSet().add("set1", "v1","v1","v3","v5","v7","v9");
        stringRedisTemplate.opsForSet().add("set2", "v2","v4","v6","v5","v10","v10");

        //绑定sert1集合操作
        BoundSetOperations setOps = stringRedisTemplate.boundSetOps("set1");
        setOps.add("v11", "v13");
        setOps.remove("v1", "v3");
        Set set = setOps.members();//返回所有元素
        LOGGER.info("集合中所有元素: "+set.toString());

        Long size = setOps.size();//求成员数
        LOGGER.info("集合长度: "+String.valueOf(size));

        Set inner = setOps.intersect("set2"); //求交集
        setOps.intersectAndStore("set2", "set1_set2");//求交集并用新的集合保存
        LOGGER.info("集合的交集: "+inner.toString());

        Set diff = setOps.diff("set2"); //求差集
        setOps.diffAndStore("set2","set1-set2"); //求差集并用新的集合保存
        LOGGER.info("集合的差集: "+diff.toString());

        Set union = setOps.union("set2"); //求并集
        setOps.unionAndStore("set2", "set1=set2"); //求并集并用新的集合保存
        LOGGER.info("集合的并集: "+union.toString());

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    /**
     * redis操作有序集合
     * @return
     */
    @RequestMapping("/zset")
    @ResponseBody
    public Map<String, Object> testZSet(){
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for(int i=1; i<=9; i++){
            //分数
            double score = i*0.1;
            //创建一个TypedTuple对象, 存入值和分数
            ZSetOperations.TypedTuple typedTuple = new DefaultTypedTuple<String>("value" + i, score);
            typedTupleSet.add(typedTuple);
        }
        LOGGER.info("新建的set: "+typedTupleSet.toString());
        //往有序集合插入元素
        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
        //绑定zset1有序集合操作
        BoundZSetOperations<String, String> zSetOps = stringRedisTemplate.boundZSetOps("zset1");
        zSetOps.add("value10", 0.26);
        Set<String> setRange = zSetOps.range(1,6);
        LOGGER.info("下标下1-6的set: " + setRange.toString());

        //按分数排序获取有序集合
        Set<String> setScore = zSetOps.rangeByScore(0.2, 0.6);
        LOGGER.info("按分数排序获取有序集合: "+ setScore.toString());

        //定义值范围
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        range.gt("value3"); //大于value3
        //range.gte("value3"); //大于等于value3
        //range.lt("value8"); //小于value8
        range.lte("value8"); //小于等于value8

        //按值排序, 注意这个排序是按字符串排序
        Set<String> setLex = zSetOps.rangeByLex(range);
        LOGGER.info("按值排序: "+setLex.toString());

        zSetOps.remove("value9", "value2");  //删除元素
        Double score = zSetOps.score("value8"); //求分数
        LOGGER.info("求value8的分数: "+score);

        //在下标区间 按分数排序, 同时返回value和score
        Set<ZSetOperations.TypedTuple<String>> rangeSet = zSetOps.rangeWithScores(1,6);
        LOGGER.info("在下标区间 按分数排序, 同时返回value和score:  "+rangeSet.toString());

        //在下标区间 按分数排序, 同时返回value和score
        Set<ZSetOperations.TypedTuple<String>> scoreSet = zSetOps.rangeByScoreWithScores(1,6);
        LOGGER.info("在下标区间 按分数排序, 同时返回value和score:  "+scoreSet.toString());

        //按从大到小排序
        Set<String> reverseSet = zSetOps.reverseRange(2, 8);
        LOGGER.info("按从大到小排序: "+reverseSet.toString());

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/multi")
    @ResponseBody
    public Map<String, Object> testMulti(){
        stringRedisTemplate.opsForValue().set("key1", "value1");

        /*List list = (List) stringRedisTemplate.execute((RedisOperations operations)->{
            operations.watch("key1");
            operations.multi();
            operations.opsForValue().set("key2", "value2");
            //operations.opsForValue().increment("key1", 1);
            //获取的值将为null, 因为redis知识把命令放入队列
            Object value2 = operations.opsForValue().get("key2");
            System.out.println("命令在队列, 所以value2为null [ " + value2 + " ] ");
            operations.opsForValue().set("key3", "value3");
            Object value3 = operations.opsForValue().get("key3");
            System.out.println("命令在队列, 所以value3为null [ " + value3 + " ] ");

            //执行exce()命令,将先判断key1是否在监控后被修改过, 如果是则不执行事务, 否则就执行事务
            return operations.exec();
        });
        System.out.println(list);*/
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }


}
