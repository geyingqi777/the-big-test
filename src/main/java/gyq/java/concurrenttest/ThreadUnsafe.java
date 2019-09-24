package gyq.java.concurrenttest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程不安全的简单例子
 */
public class ThreadUnsafe {
	/**
	 * 这是一个验证结果的变量
	 */
	private static int a = 0;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 1000; i++) {
			executorService.execute(new ThreadTest());
		}
		executorService.shutdown();
		// 等1000个兄弟执行完
		while (!executorService.isTerminated()) {
		}
		// 需要的结果是a的值会小于1000
		System.out.println(a);
	}

	static class ThreadTest extends Thread {
		public void run() {
			try {
				// 先休息一下,等等后来的兄弟,更容易产生需要的结果
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// a++不是一个原子操作,而是分为,读取a,得到a+1的结果,结果赋值给a,三步
			a++;
		}
	}
}