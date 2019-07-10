package gyq.java.lang.test;

/**
 * Created by Asa on 2019/1/2.
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        int b = 1;
        // 自动装箱
        Integer c = b;

        // 比较双方,存在int类型,自动拆箱了,结果为true
        System.out.println(a == b);
        // 比较双方都是integer对象,不会自动拆箱,比较内存地址,结果为false
        System.out.println(a == c);
        // 溢出测试
        a = a + Integer.MAX_VALUE;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(a);

        // ++ 在前后的区别: 在后的,先执行其他的再加, 在前的,先加再执行其他的
        int i = 1;
        System.out.println(i++);
        System.out.println(++i);

        System.out.println(352438686 % 256);

        Double zero = Double.valueOf("0");
        Double one = Double.valueOf("1");
        // double型,运行时,会得到Infinity
        System.out.println((double) 1 / (double) 0);
        // double型,运行时,会得到NaN
        System.out.println((double) 0 / (double) 0);
        // int类型,运行时会抛异常`Exception in thread "main" java.lang.ArithmeticException: / by zero`
        System.out.println(1 / 0);
    }
}
