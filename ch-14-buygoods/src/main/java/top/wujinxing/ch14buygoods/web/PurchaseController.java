package top.wujinxing.ch14buygoods.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.wujinxing.ch14buygoods.service.PurchaseService;

/**
 * @author wujinxing
 * date 2019 2019/5/14 10:28
 * description
 */
@RestController
public class PurchaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);
    @Autowired
    PurchaseService purchaseService;

    //定义JSP视图
    @GetMapping("/test")
    public ModelAndView testPage(){
        ModelAndView mv = new ModelAndView("test1");
        LOGGER.info("返回视图: " + mv.getViewName());
        return mv;
    }

    @PostMapping("/purchase")
    public Result purchase(Long userId, Long productId,Integer quantity){
        boolean success = purchaseService.purchase(userId, productId, quantity);
        String message = success? "抢购成功" : "抢购失败";
        Result result = new Result(success, message);
        LOGGER.info("结果result: " + result.toString());
        return result;
    }

    // 响应结果
    class Result {
        private boolean success = false;
        private String message = null;

        public Result() {
        }

        public Result(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        /**** setter and getter ****/

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
