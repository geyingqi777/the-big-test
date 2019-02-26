package gyq.java.lang.test;

/**
 * 同步对性能的影响还是很大的啊
 * 
 * @author Asa
 * @version 创建时间：2016年8月2日 下午5:51:47
 */
public class SynchronizedTest {
	private static Object lock = new Object();

	public static void main(String[] args) {
		for (int k = 0; k < 10; k++) {
			long start = System.currentTimeMillis();
			for (int j = 0; j < 10000000; j++) {
				synchronized (lock) {
					int i = 1;
				}
			}
			System.out.println("同步的：" + (System.currentTimeMillis() - start));

			start = System.currentTimeMillis();
			for (int j = 0; j < 10000000; j++) {
				int i = 1;
			}
			System.out.println("不同步的：" + (System.currentTimeMillis() - start));
		}

	}
}
