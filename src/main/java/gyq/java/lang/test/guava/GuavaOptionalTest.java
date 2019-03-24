package gyq.java.lang.test.guava;

import com.google.common.base.Optional;

import java.util.Set;

/**
 * guava的optional的学习
 * <p>
 * Created by geyingqi on 2019-03-24.
 */
public class GuavaOptionalTest {
    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.of(1);
        Optional<Integer> optional2 = Optional.of(2);
        // 自动增加NullPointerException检测
        // Optional<Integer> optional3 = Optional.of(new Integer(null));
        Integer integer = sum(optional1, optional2);
        System.out.println(integer);
        // 返回是否包含非null的实例
        boolean present = optional1.isPresent();
        System.out.println(present);
        // 创建一个包含null的对象
        Optional<Object> absent = Optional.absent();
        // 这个对象不能执行get, 会提示java.lang.IllegalStateException: Optional.get() cannot be called on an absent value
        // absent.get();
        // 返回一个单元素的不可变set
        Set<Integer> integerSet = optional1.asSet();
        // 转成java的optional的对象
        java.util.Optional<Integer> integer1 = optional1.toJavaUtil();
        // null时,返回值得到10
        Integer or = (Integer) absent.or(10);
        System.out.println(or);
        // null时,返回null
        Object orNull = absent.orNull();
        System.out.println(orNull == null);
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }
}
