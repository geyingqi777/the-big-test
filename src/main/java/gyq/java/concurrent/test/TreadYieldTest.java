package gyq.java.concurrent.test;

/**
 * 测试线程的yield方法
 * Created by Asa on 2019-01-04.
 */
public class TreadYieldTest extends Thread {

	public TreadYieldTest(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			System.out.println("" + this.getName() + "-----" + i);
			// 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
			if (i == 30) {
				this.yield();
			}
		}
	}

	public static void main(String[] args) {
		TreadYieldTest yt1 = new TreadYieldTest("线程1");
		TreadYieldTest yt2 = new TreadYieldTest("线程2");
		yt1.start();
		yt2.start();
	}
}

