package gyq.java.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * guava的布隆过滤器学习
 * <p>
 * Created by geyingqi on 2019-03-24 15:05.
 */
public class GuavaBloomFilterTest {
    public static void main(String[] args) {
        int size = 10000000;
        // 布隆过滤器的错误率
        double fpp = 0.02;
        BloomFilter<Long> longBloomFilter = BloomFilter.create(Funnels.longFunnel(), size, fpp);

        // 把这些数都放进去过滤器中
        for (long i = 0; i < size; i++) {
            longBloomFilter.put(i);
        }

        long startTime = System.nanoTime(); // 获取开始时间
        //判断这一百万个数中是否包含29999这个数
        if (longBloomFilter.mightContain(29999L)) {
            System.out.println("命中了");
        }
        // 返回一个接近总元素数量的值,有一定误差
        long approximateElementCount = longBloomFilter.approximateElementCount();
        System.out.println(approximateElementCount);

        // 返回当前错误率
        double expectedFpp = longBloomFilter.expectedFpp();
        System.out.println(expectedFpp);

        long endTime = System.nanoTime();   // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "纳秒");
    }
}
