package gyq.java.algorithm.leetcode.sort.dynamic;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * Created by Asa on 2019-02-21.
 */
public class UpStairs {
	public static void main(String[] args) {
		// System.out.println(calculateCount(6, 2));
		// System.out.println(fun(null, 6));
		fun(null, 6);
	}

	/**
	 * 递归的方式
	 * 
	 * 假设一个楼梯有 N 阶台阶，人每次最多可以跨 M 阶，求总共的爬楼梯方案数。
	 *
	 * 例如楼梯总共有3个台阶，人每次最多跨2个台阶， 也就是说人每次可以走1个，也可以走2个，
	 *
	 * 但最多不会超过2个， 那么楼梯总共有这么几种走法
	 * 
	 * @param ladder
	 * @param maxJump
	 * @return
	 */
	private static int calculateCount(int ladder, int maxJump) {
		int jump = 0;
		if (ladder == 0) {
			return 1;
		}
		if (ladder >= maxJump) {
			// 剩下的楼梯大于每一步的最大级数
			for (int i = 1; i <= maxJump; i++) {
				jump += calculateCount(ladder - i, maxJump);
			}
		} else {
			// 剩下的楼梯不足最大可跳跃数
			jump = calculateCount(ladder, ladder);
		}
		return jump;
	}

	private static long fun(List<Integer> list, int n) {
		if (list == null) {
			list = new LinkedList<>();
		}
		if (n == 1) { // 一级台阶只有1种方法
			list.add(1);
			return 1;
		} else if (n == 2) {
			list.add(2);
			return 2;
		} // 二级台阶2种，其实可以省略的 不过为了初学者能够看清楚 我这里写出来

		long l = fun(list, n - 1) + fun(list, n - 2);
		if (n == 6) {
			System.out.println(JSON.toJSONString(list));
		}
		return l;
	}

}
