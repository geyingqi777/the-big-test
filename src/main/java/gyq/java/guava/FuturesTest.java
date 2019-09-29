package gyq.java.guava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * @author geyingqi
 * @date 2019-09-29 15:08
 */
@Slf4j
public class FuturesTest {
    @Test
    public void test1() throws Exception {
        log.info("主线程start");
        // 线程池装饰者
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
        // 模拟实际的异步任务
        Task task1 = new Task();
        task1.name = "task1";
        Task task2 = new Task();
        task2.name = "task2";
        // 把异步任务提交到线程池
        ListenableFuture<String> future = pool.submit(task1);
        ListenableFuture<String> future2 = pool.submit(task2);

        /**
         * FutureCallBack接口这种方式创建的回调也是异步线程
         */
        FutureCallback<String> futureCallback = new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                log.info("成功回调函数" + result);
            }

            @Override
            public void onFailure(Throwable t) {
                log.info("失败回调函数");
            }
        };

        // 回调函数
        Futures.addCallback(future, futureCallback, pool);
        Futures.addCallback(future2, futureCallback, pool);
        // 异步任务增加一个回调函数,也是创建一个异步线程来执行的
        future.addListener(() -> log.info("task1 addListener执行"), pool);
        future2.addListener(() -> log.info("task2 addListener执行"), pool);

        // 执行
        log.info(future.get());
        log.info(future2.get());
        Thread.sleep(100);
        log.info("主线程end");
        // 15:54:26.192 [main] INFO gyq.java.guava.FuturesTest - 主线程start
        // 15:54:26.319 [pool-1-thread-1] INFO gyq.java.guava.FuturesTest - 任务执行task1
        // 15:54:26.319 [pool-1-thread-2] INFO gyq.java.guava.FuturesTest - 任务执行task2
        // 15:54:26.320 [main] INFO gyq.java.guava.FuturesTest - 返回值task1
        // 15:54:26.320 [pool-1-thread-2] INFO gyq.java.guava.FuturesTest - task2 addListener执行
        // 15:54:26.320 [main] INFO gyq.java.guava.FuturesTest - 返回值task2
        // 15:54:26.320 [pool-1-thread-5] INFO gyq.java.guava.FuturesTest - task1 addListener执行
        // 15:54:26.321 [pool-1-thread-3] INFO gyq.java.guava.FuturesTest - 成功回调函数返回值task1
        // 15:54:26.321 [pool-1-thread-4] INFO gyq.java.guava.FuturesTest - 成功回调函数返回值task2
        // 15:54:26.423 [main] INFO gyq.java.guava.FuturesTest - 主线程end
    }

    /**
     * 异步任务
     */
    class Task implements Callable<String> {
        String name;

        @Override
        public String call() throws Exception {
            Thread.sleep(100);
            log.info("任务执行" + name);
            return "返回值" + name;
        }
    }
}
