package top.wujinxing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Slf4j
public class AsyncDemoErrorCatch {

    @Async
    public void asyncInvokeSimplest() {
      log.info("asyncInvokeSimplest");
      throw new IllegalArgumentException("asyncInvokeSimplest");
    }

    @Async
    public void asyncInvokeParameter(String s) throws InterruptedException {
        log.info("asyncInvokeParameter: {}", s);
        throw new IllegalArgumentException(String.format("asyncInvokeParameter: %s", s));
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
        } catch (IllegalArgumentException e) {
            future = new AsyncResult<>("error-IllegalArgumentException");
        }
        return future;
    }
}
