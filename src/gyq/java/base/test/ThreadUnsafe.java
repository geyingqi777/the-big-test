package gyq.java.base.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程不安全的简单例子
 */
public class ThreadUnsafe {
	/** 这是一个验证结果的变量 */
	private static int a = 1;
	private static boolean bRun = false;
	// 循环次数记录
	private static AtomicInteger i = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		// 由于多线程情况下未必会试出重排序的结论,所以多试一些次
		while (i.addAndGet(1) < 1000000) {
			ThreadA threadA = new ThreadA();
			threadA.start();
			ThreadB threadB = new ThreadB();
			threadB.start();
			threadA.join();// join的作用是主线程进入wait状态,等threadA执行完成之后才继续执行
			threadB.join();
			/*
			 * 这里a=0的赋值可能会排到前面???, 如果在theadA和threadB之间执行,就会打印出信息???
			 */
			// 重置共享变量
			bRun = false;
			a = 0;
		}
	}

	static class ThreadA extends Thread {
		public void run() {
			if (bRun) {
				System.out.println(String.format("ThreadB already run %s", i));
			}
			a = 1;
		}
	}

	static class ThreadB extends Thread {
		public void run() {
			bRun = true;
			if (a == 0) {
				System.out.println(String.format("ThreadB a==0 %s", i));
			}
		}
	}
}