package top.wujinxing.ch14buygoods.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.wujinxing.ch14buygoods.pojo.ProductPo;

/**
 * @author wujinxing
 * date 2019 2019/5/14 10:00
 * description
 */
@Mapper
@Component  // 加入注解防止注入报错
public interface ProductDao {
    // 获取产品
    public ProductPo getProduct(Long id);

    //减库存，而@Param标明MyBatis参数传递给后台
    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);

//    public int decreaseProduct(@Param("id") Long id,
//    	    @Param("quantity") int quantity, @Param("version") int version);
}
