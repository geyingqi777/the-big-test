package gyq.java.concurrent.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试重排序在多线程环境下带来的影响
 * Created by Asa on 2019-01-03.
 */
public class CommandReorder {
	private static List<String> a = null;
	private static List<String> b = null;
	private static boolean flag = false;
	private static boolean flag1 = false;
	private static boolean flag2 = false;
	private static boolean flag3 = false;
	private static boolean flag4 = false;

	public static void main(String[] args) {
		ExecutorService executorService = null;
		for (int i = 0; i < 10000; i++) {
			// 重置一下共享变量 
			a = null;
			b = null;
			flag = false;
			flag1 = false;
			flag2 = false;
			flag3 = false;
			flag4 = false;
			if (flag == false && flag1 == false && flag2 == false && flag3 == false && flag4 == false && a == null && b == null) {
				executorService = Executors.newFixedThreadPool(2);
				// 怎么才能排除多线程带来的安全问题,只体现重排序的问题呢,就要确保同一时刻只有这两个线程
				ThreadTest1 threadTest1 = new ThreadTest1();
				ThreadTest2 threadTest2 = new ThreadTest2();
				executorService.submit(threadTest1);
				executorService.submit(threadTest2);
				executorService.shutdown();
				while (!executorService.isTerminated()) {
					// 确保2个线程都执行完了,再执行下一个循环
				}
			}
		}
	}

	private static class ThreadTest1 extends Thread {

		@Override
		public void run() {
			// 此处可能重排序,先执行flag=true
			a = new ArrayList<>(100000);  //1
			b = new ArrayList<>(100000);  //1
			// FIXME: 2019-01-04 
			//  只要任何一个flag赋值排到前面先执行了, 就会得到想要的错误结果了,但是现在还是重现不了
			flag = true;        //2
			flag1 = true;        //2
			flag2 = true;        //2
			flag3 = true;        //2
			flag4 = true;        //2
		}
	}

	private static class ThreadTest2 extends Thread {

		@Override
		public void run() {
			if (flag || flag1 || flag2 || flag3 || flag4) {
				// 重排序在多线程环境下可能会导致flag==true&&a==null,打印出reorder
				if (a == null || b == null) {
					System.out.println("reorder");
				}
			}

		}
	}

}
