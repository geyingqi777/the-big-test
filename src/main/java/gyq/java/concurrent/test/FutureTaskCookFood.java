package gyq.java.concurrent.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.math.RandomUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试future的执行模式和用法
 */
public class FutureTaskCookFood {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// 第一步 网购锅
		Callable<Wok> onlineShopping = new Callable<Wok>() {

			@Override
			public Wok call() throws Exception {
				System.out.println("第一步：下单");
				System.out.println("第一步：等待送货");
				Thread.sleep(5000);  // 模拟送货时间
				System.out.println("第一步：快递送到");
				Wok wok = new Wok();
				wok.setName("章丘铁锅");
				return wok;
			}

		};
		FutureTask<Wok> task = new FutureTask<>(onlineShopping);
		new Thread(task).start();
		// 第二步 去超市购买食材
		try {
			Thread.sleep(2000);  // 模拟购买食材时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Food food = new Food();
		System.out.println("第二步：食材到位");
		// 第三步 用锅烹饪食材
		if (!task.isDone()) {  // 联系快递员，询问是否到货
			int i = RandomUtils.nextInt(2);
			if (i == 1) {
				System.out.println("第三步：锅还没到，再等等");
			} else {
				System.out.println("快递太慢,取消订单,申请退款");
				task.cancel(true);

			}
		}
		// get方法会阻塞等待结果
		Wok wok = null;
		try {
			wok = task.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (CancellationException e) {
			// 取消之后再get会抛出java.util.concurrent.CancellationException
			e.printStackTrace();
		}
		System.out.println(String.format("第三步：厨具%s送到", JSON.toJSONString(wok)));
		cook(wok, food);

		System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
	}

	//  用厨具烹饪食材
	static void cook(Wok wok, Food food) {
		System.out.println("烹饪...");
	}

	// 厨具类
	static class Wok {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	// 食材类
	static class Food {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}