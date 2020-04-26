package gyq.java.guava;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author geyingqi
 * @date 2020-01-03 15:26
 */
@Slf4j
public class RateLimiterTest {
    @Test
    public void test1() {
        // 利用令牌桶算法的思想实现的限流

        // 这个构造方法,提供了预热的时间, 可以自定义预热时间,期间令牌产生速度会逐渐提升,直到达到设置的最大值
        // RateLimiter rateLimiter = RateLimiter.create(2, 10, TimeUnit.SECONDS);

        // 这个构造方法,全程匀速产生令牌,按照配置的值 
        RateLimiter rateLimiter = RateLimiter.create(1);

        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            // 首次会立刻得到1个令牌, 令牌不足时,会阻塞等待获取, 返回值是等待获取令牌的时间 
            double acquire = rateLimiter.acquire();
            boolean tryAcquire = rateLimiter.tryAcquire();
            log.info("RateLimiterTest.test1 [等待时间] acquire={}", acquire);
            log.info("RateLimiterTest.test1 [执行操作已过时间] cost={}", System.currentTimeMillis() - currentTimeMillis);
            // 可以支持设置频率,每过20个,每秒多产生1个
            if (i % 20 == 0 && i > 0) {
                rateLimiter.setRate(rateLimiter.getRate() + 1);
            }
        }
    }
}
