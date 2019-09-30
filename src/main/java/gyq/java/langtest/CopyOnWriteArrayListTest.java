package gyq.java.langtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author geyingqi
 * @date 2019-09-30 10:33
 */
@Slf4j
public class CopyOnWriteArrayListTest {
    @Test
    public void test1() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        // 该方法会先判断是否存在该元素, 不存在时,才会加锁并添加
        boolean addIfAbsent = list.addIfAbsent(1);
        log.info("gyq.java.langtest-->test1:: {}", addIfAbsent);
        addIfAbsent = list.addIfAbsent(1);
        log.info("gyq.java.langtest-->test1:: {}", addIfAbsent);
    }
}
