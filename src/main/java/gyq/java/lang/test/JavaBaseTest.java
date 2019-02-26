package gyq.java.lang.test;

public class JavaBaseTest {
	public static void main(String[] args) {
		// while (true) {
		// System.out.println(new Random().nextInt(1));
		// }

		System.out.println(Integer.MAX_VALUE * Integer.MAX_VALUE); // 内存溢出
		// System.out.println(Integer.MAX_VALUE);
		// //2的31次方-1,10个数位，正的20亿左右,用在钱上面不一定够
		// System.out.println(Integer.MIN_VALUE); //负的2的31次方
		System.out.println(Long.MAX_VALUE); // 2的64次方-1,19个数位，很大了,可放心用在钱上面
		// System.out.println(Long.MIN_VALUE); //负的2的64次方
		System.out.println(Float.MAX_VALUE);
		// 2的128次方-1,38个数位，比long多了一倍,这个主要用来做简单数学精确运算使用
		// System.out.println(Float.MIN_VALUE); //2的-149次方
		// System.out.println(Double.MAX_VALUE);
		// //2的1024次方-1,308个数位，是float数位的10倍，主要用来做复杂运算和天文运算
		// System.out.println(Double.MIN_VALUE); //2的-1074次方
		System.out.println(-1024 >> 12);

		System.out.println(9 + -2);
		// 这个只有在乘以5结尾的数的时候才会出现误差，原因还没弄懂。。
		float t = 0.01f;
		float a = 5 * t;
		int b = (int) (a * 100);
		System.out.println(a + " " + b);
	}
}
