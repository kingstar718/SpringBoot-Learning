package top.wujinxing.ch14buygoods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wujinxing.ch14buygoods.dao.ProductDao;
import top.wujinxing.ch14buygoods.dao.PurchaseRecordDao;
import top.wujinxing.ch14buygoods.pojo.ProductPo;
import top.wujinxing.ch14buygoods.pojo.PurchaseRecordPo;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/14 10:05
 * description
 */
@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private ProductDao productDao = null;

    @Autowired
    private PurchaseRecordDao purchaseRecordDao = null;


    @Override
    @Transactional//启动Spring数据库事务机制
    public boolean purchase(Long userId, Long productId, int quantity) {
        //获取产品
        ProductPo product = productDao.getProduct(productId);
        //比较库存和购买数量
        if (product.getStock()<quantity){
            //库存不足
            return false;
        }
        //扣减库存
        productDao.decreaseProduct(productId, quantity);
        //初始化购买记录
        PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
        //插入购买记录
        purchaseRecordDao.insertPurchaseRecord(pr);
        return true;
    }

    @Override
    public boolean purchaseRedis(Long userId, Long productId, int quantity) {
        return false;
    }

    @Override
    public boolean dealRedisPurchase(List<PurchaseRecordPo> prpList) {
        return false;
    }

    //初始化购买信息
    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity){
        PurchaseRecordPo pr= new PurchaseRecordPo();
        pr.setNote("购买日志, 时间: " + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);

        double sum = product.getPrice()*quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
