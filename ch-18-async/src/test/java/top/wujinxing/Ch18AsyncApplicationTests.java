package top.wujinxing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch18AsyncApplication.class)
@Slf4j
public class Ch18AsyncApplicationTests {

    @Autowired
    private AsyncDemo asyncDemo;

    @Autowired
    private AsyncDemoErrorCatch errorCatch;

    @Test
    public void testAsync() throws ExecutionException, InterruptedException {
        asyncDemo.asyncInvokeSimplest();
        asyncDemo.asyncInvokeParameter("test");
        Future<String> future = asyncDemo.asyncInvokeReturnFuture(100);
        log.info(future.get());
    }
    @Test
    public void catchException() throws InterruptedException, ExecutionException {
        errorCatch.asyncInvokeSimplest();
        errorCatch.asyncInvokeParameter("test");
        Future<String> future = asyncDemo.asyncInvokeReturnFuture(100);
        log.info(future.get());
    }
}
