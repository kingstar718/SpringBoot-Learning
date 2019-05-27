package top.wujinxing.ch14buygoods.service;

import top.wujinxing.ch14buygoods.pojo.PurchaseRecordPo;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/14 10:04
 * description
 */
public interface PurchaseService {
    /**
     * 处理购买业务
     * @param userId 用户编号
     * @param productId 产品编号
     * @param quantity 购买数量
     * @return 成功or失败
     */
    public boolean purchase(Long userId, Long productId, int quantity);

    boolean purchaseRedis(Long userId, Long productId, int quantity);

    boolean dealRedisPurchase(List<PurchaseRecordPo> prpList);
}
