package gyq.java.concurrenttest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量测试
 *
 * @author geyingqi
 * @date 2020-01-03 18:03:02
 */
@Slf4j
public class SemaphoreTest {
    @Test
    public void test1() {
        ExecutorService pool = Executors.newCachedThreadPool();
        // 信号量,按照信号灯来理解就容易多了
        final Semaphore semaphore = new Semaphore(3, true);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();//获取信号灯许可
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread " + Thread.currentThread().getName() + " 进入" + "当前系统的并发数是：" + (3 - semaphore.availablePermits()));
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Thread " + Thread.currentThread().getName() + " 即将离开");
                    semaphore.release();//释放信号灯
                    System.out.println("Thread " + Thread.currentThread().getName() + " 已经离开，当前系统的并发数是：" + (3 - semaphore.availablePermits()));
                }
            };
            pool.execute(runnable);

        }
    }
}