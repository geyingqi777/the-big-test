package gyq.java.algorithm.bit;

/**
 * todo 整理一下位运算的算法
 *
 * @author Asa
 * @version 创建时间：2016年8月3日 上午10:14:37
 */
public class BitTest {
    public static void main(String[] args) {
        int i = 10000;
        long l = 10000l;
        System.out.println(Long.bitCount(l));// 这个源码看不懂啊，是因为不太懂移位运算
        System.out.println(Long.toBinaryString(l));
        System.out.println(Integer.bitCount(i));
        System.out.println(Integer.toBinaryString(i));

        // 也可以用手写版的算法,3种
        int i2 = -10000;
        System.out.println(Sum1ByBin0(i2, i2 < 0));

    }

    /**
     * 这种方式算法时间复杂度和二进制的总位数相关,用了取模运算，这种方法正负数都适用,别的都是用位运算的，简直高大上
     *
     * @author Asa
     * @version 2016年8月3日 上午11:04:11
     */
    public static int Sum1ByBin0(int n, boolean negative) {
        int sum = 0;
        int flag = negative ? -1 : 1;
        while (n != 0) {
            if (n % 2 == flag) {
                sum++;
            }
            n /= 2;
        }
        return sum;
    }

    /**
     * 这种方式算法时间复杂度和二进制的总位数相关 当n为负数时，n右移在最高位补1（为了保证数据为负数），因而最终就会形成死循环！
     *
     * @author Asa
     * @version 2016年8月3日 上午10:44:07
     */
    public static int Sum1ByBin1(int n) {
        int count = 0;
        int flag = 1;
        while (n != 0) {
            if ((n & flag) == flag) {
                count++;
            }
            n >>= 1;
        }

        return count;
    }

    /**
     * 移动的不是数据n而是1,可以解决算法1中负数死循环的问题
     *
     * @author Asa
     * @version 2016年8月3日 上午10:56:37
     */
    public static int Sum1ByBin2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) == flag) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 这种方式算法时间复杂度和二进制其中1的个数相关，比上一种更好
     *
     * @author Asa
     * @version 2016年8月3日 上午10:44:07
     */
    public static int Sum1ByBin3(int n) {
        // 判断一个数二进制中有几个1手写版算法，正负数都适用
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
