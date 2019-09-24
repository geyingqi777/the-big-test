package gyq.java.langtest;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		int bound = 10;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int value = random.nextInt(bound);
			System.out.println(value + "");
		}
		System.out.println("====================");

		// 不用currentTimeMillis的原因是：当多线程调用时，由于CPU速率很快，因此currentTimeMillis很可能相等，使得随机数结果也会相等
		// long seed1 = System.currentTimeMillis();
		// nanoTime()返回最准确的可用系统计时器的当前值,以毫微秒为单位。此方法只能用于测量已过的时间,与系统或钟表时间的其他任何时间概念无关。
		long seed1 = System.nanoTime();
		Random seedRandom1 = new Random(seed1);
		for (int i = 0; i < 10; i++) {
			/*
			 * 产生一个[0,bound)之间的随机数 设a<b, 要产生一个[a,b)之间的随机数的公式为: int value = a + random.nextInt(b-a);
			 */
			int value = seedRandom1.nextInt(bound);
			System.out.println(value + "");
		}
		System.out.println("====================");

		long seed2 = 10;
		// 当种子一样的时候，虽然每次nextXXX的方法会返回不同的结果，
		// 但是由于每次new Random(相同的seed)创建的“随机数生成器”都相同，因此之后产生的随机数序列也就都是一样的。
		// 所以每次调用该函数生成随机数都会产生相同的结果。
		Random seedRandom2 = new Random(seed2);
		for (int i = 0; i < 10; i++) {
			int value = seedRandom2.nextInt(bound);
			System.out.println(value + "");
		}
	}

}