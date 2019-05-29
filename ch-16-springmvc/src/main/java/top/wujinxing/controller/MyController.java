package top.wujinxing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinxing
 * date 2019 2019/5/29 17:42
 * description
 */
@RequestMapping("/my")
@Controller
public class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    //无须任何注解的情况下 ，就要求 HTTP 参数和控制器方法参数名称保持一致。
    //参数可以不传, 就默认为空
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String, Object> noAnnotation(Integer intVal, Long longVal, String str){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intVal", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", str);
        LOGGER.info(paramsMap.toString());
        return paramsMap;
    }

    //使用RequestParam传递参数  可传进与变量名不同的参数， 默认为true
    @GetMapping("/annotation")
    @ResponseBody
    public Map<String, Object> requestParam(
            @RequestParam("int_val") Integer intVal,
            @RequestParam("long_val") Long longVal,
            @RequestParam("str_val") String strVal){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intVal", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", strVal);
        LOGGER.info(paramsMap.toString());
        return paramsMap;
    }


    //传递数组
    @GetMapping("/requestArray")
    @ResponseBody
    public Map<String, Object> requestAraay(int[] intArr, Long[] longArr, String[] strArr){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("intArr", intArr);
        paramsMap.put("longArr", longArr);
        paramsMap.put("strArr", strArr);
        LOGGER.info(paramsMap.toString());
        return paramsMap;
    }
}
