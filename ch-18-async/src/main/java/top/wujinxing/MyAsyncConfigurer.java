package top.wujinxing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

@Service
public class MyAsyncConfigurer implements AsyncConfigurer {

    /**
     * 自定义异步处理的线程池
     * @return executor
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("async-task-");
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    /**
     * 自定义异步处理类
     */
    @Slf4j
    static class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("exception message: {}", throwable.getMessage());
            log.info("method name: {}", method.getName());
            for (Object param: objects) {
                log.info("parameter value: {}", param);
            }
        }
    }
}
