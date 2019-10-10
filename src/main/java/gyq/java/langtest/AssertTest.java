package gyq.java.langtest;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author geyingqi
 * @date 2019-10-10 16:38
 */
@Slf4j
public class AssertTest {
    @Test
    public void test1() {
        Object object = null;
        try {
            // 这个抛出一个java.lang.AssertionError, 注意如果用Exception的话是无法被捕获的
            assert object != null;
        } catch (Throwable e) {
            log.error("java assert {}", e.toString());
        }
        try {
            Assert.notNull(object, "空的");
        } catch (Exception e) {
            log.error("spring assert {}", e.toString());
        }
    }
}
