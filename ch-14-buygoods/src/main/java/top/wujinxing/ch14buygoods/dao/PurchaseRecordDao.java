package top.wujinxing.ch14buygoods.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.wujinxing.ch14buygoods.pojo.PurchaseRecordPo;

/**
 * @author wujinxing
 * date 2019 2019/5/14 10:01
 * description
 */
@Mapper
@Component // 加入注解防止注入报错
public interface PurchaseRecordDao {
    public int insertPurchaseRecord(PurchaseRecordPo pr);
}

