package top.wujinxing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Slf4j
public class AsyncDemo {

    @Async
    public void asyncInvokeSimplest() throws InterruptedException {
        Thread.sleep(500);
      log.info("asyncInvokeSimplest");
    }

    @Async
    public void asyncInvokeParameter(String s) throws InterruptedException {
        Thread.sleep(200);
        log.info("asyncInvokeParameter: {}", s);
    }

    @Async
    public Future<String> asyncInvokeReturnFuture(int i) {
        log.info("asyncInvokeReturnFuture, parameter is {}", i);
        Future<String> future;
        try {
            Thread.sleep(1000 * 1);
            future = new AsyncResult<>("success: " + i);
        } catch (InterruptedException e) {
            future = new AsyncResult<>("error");
            log.error("asyncInvokeReturnFuture", e);
        }
        return future;
    }
}
