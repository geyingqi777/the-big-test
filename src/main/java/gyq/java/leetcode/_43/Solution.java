package gyq.java.leetcode._43;

import java.math.BigDecimal;

import com.alibaba.fastjson.JSON;

/**
 * 字符串相乘 Created by ge_yi on 2019/2/18.
 */
public class Solution {
	/**
	 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
	 *
	 * 示例 1:
	 *
	 * 输入: num1 = "2", num2 = "3" 输出: "6"
	 * 
	 * 示例 2:
	 *
	 * 输入: num1 = "123", num2 = "456" 输出: "56088"
	 * 
	 * 说明：
	 *
	 * num1 和 num2 的长度小于110。 num1 和 num2 只包含数字 0-9。 num1 和 num2 均不以零开头，除非是数字 0 本身。
	 * 
	 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply(String num1, String num2) {
		// 本方法的解决思路是完全模拟小学乘法竖式的方式, 完全还原且没有利用乘积位置的规律
		
		// 而且为了便于理解,总是把更短的那个数值放在竖式下面, 长的放在竖式上面
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		// 让长度长的放在num1
		int length = num1.length();
		int length1 = num2.length();
		String numLonger;
		String numShorter;
		int lengthLonger;
		int lengthShorter;
		if (length >= length1) {
			numLonger = num1;
			numShorter = num2;
			lengthLonger = length;
			lengthShorter = length1;
		} else {
			numLonger = num2;
			numShorter = num1;
			lengthLonger = length1;
			lengthShorter = length;
		}
		int lineCount = lengthShorter;// 行数
		// 列数加1的原因: 每一次j循环完了之后,得到的数字位数可能为length2和length1中较大的再多1位,
		// 因为两个个位数相乘最大是81 再加上前面最多进也小于10, 合起来是还是2位数, 循环到了最前一位, 只多出1位数字
		int rowCount = lengthLonger + 1;// 列数
		// lineCount行rowCount列元素的二维数组
		int[][] array = new int[lineCount][rowCount];

		// 注: 此处可以不用二维数组, 用一个字符串数组也可以,比二维数组更容易理解

		// 外层循环,在小学乘法竖式中,放在下面
		for (int i = lengthShorter - 1; i >= 0; i--) {
			// 因为两个个位数相乘最大是81 再加上前面最多进9, 合起来是90, 循环到了最前一位, 只多出1位数字, 所以这里需要保留到10位
			int position10 = 0;
			// 内层循环,在乘法竖式中,放在上面
			for (int j = lengthLonger - 1; j >= 0; j--) {
				char c = numLonger.charAt(j);
				// 通过和字符'0'的差值,得到该位的int数值
				int n1 = c - '0';
				char c1 = numShorter.charAt(i);
				// 得到该位的int数值
				int n2 = c1 - '0';
				// 这里注意:上一次进位的十位,下一次加到个位,百位加到十位, 千位加到百位
				int multiply = n1 * n2 + position10 * 1;
				// 得到个位数
				int positon1 = multiply % 10;
				array[lengthShorter - 1 - i][j + 1] = positon1;
				// 得到十位数
				position10 = multiply % 100 / 10;
			}
			// 最后得到该行的首位
			array[lengthShorter - 1 - i][0] = position10;
		}
		// for (int[] ints : array) {
		// 	// 打印一行看下
		// 	System.out.println(JSON.toJSONString(ints));
		// }

		// 最后把二维数组按列相加, 此处还是不能用int直接相加,可能会溢出
		// 外层循环是列
		StringBuilder stringBuilder = new StringBuilder();
		int position10 = 0;// 十位
		int position100 = 0;// 百位
		// 题目限定了num1 和 num2 的长度小于110, 所以竖式中,一列最大为110个9相加, 为990, 前面进位过来的数可能大于10, 合起来大于1000时,向前进位可能大于100
		// 所以这里需要保留到千位
		int position1000 = 0;// 千位
		for (int i = 0; i < rowCount + lineCount; i++) {
			StringBuilder stringBuilder1 = new StringBuilder("5023045302335819");
			if (stringBuilder1.reverse().toString().equals(stringBuilder.toString())) {
				System.out.println("错误调试时从后往前找到没错的那一位,debug用");
			}
			int sum = 0;
			// 内层循环是行
			for (int j = 0; j < lineCount; j++) {
				// 要加倒数第几列,就取前几行
				if (j <= i) {
					int row = rowCount - 1 - i + j;
					if (row >= 0) {
						int int1 = array[j][rowCount - 1 - i + j];
						sum = sum + int1;
					}
				}
			}
			// 这里注意:上一次进位的十位,下一次加到个位,百位加到十位, 千位加到百位
			sum = sum + position10 * 1 + position100 * 10 + position1000 * 100;
			// 这一列加完了
			// 得到个位数
			int positon1 = sum % 10;
			// 得到十位数
			position10 = sum % 100 / 10;
			// 取得百位
			position100 = sum % 1000 / 100;
			// 取得千位
			position1000 = sum % 10000 / 1000;
			stringBuilder.append(positon1);
		}
		stringBuilder.append(position10).append(position100).append(position1000);
		String s = stringBuilder.reverse().toString();
		// 去掉开头的0
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0') {
				s = s.substring(i);
				break;
			}
		}
		return s;
	}

	/**
	 * 另一种答案
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply2(String num1, String num2) {
		// 先把string翻转
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		// 两个数值的乘积, 位数不会大于两个数值的位数之和
		int[] d = new int[n1.length() + n2.length()]; // 构建数组存放乘积
		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				// 这个算法,了解乘积位置的规律最重要
				// 乘积位置的规律: 乘法运算的时候每一个都要相乘也就是n*n
				// 当被乘数到达第二位的时候乘以乘数的第一位就要写到第二位
				// 由此得到结果摆放的位置按i+j
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0'); // 在正确位置累加乘积
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			int digit = d[i] % 10; // 当前位
			int carry = d[i] / 10; // 进位
			if (i + 1 < d.length) {
				d[i + 1] += carry;
			}
			sb.insert(0, digit); // prepend
		}
		// 移除前导零
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s2 = "401716832807512840963";
		String s1 = "23557397451289113";
		String multiply = solution.multiply(s1, s2);
		System.out.println(multiply);
		BigDecimal bigDecimal = new BigDecimal(s1);
		BigDecimal bigDecimal1 = new BigDecimal(s2);
		String string = bigDecimal.multiply(bigDecimal1).toString();
		System.out.println(string);
		System.out.println(string.equalsIgnoreCase(multiply));

		// long begin = System.currentTimeMillis();
		// for (int i = 10000000; i < 20000000; i++) {
		// for (int j = 10000000; j < 20000000; j++) {
		// String ss1 = String.valueOf(i);
		// String ss2 = String.valueOf(j);
		// BigDecimal bigDecimal3 = new BigDecimal(ss1);
		// BigDecimal bigDecimal4 = new BigDecimal(ss2);
		// String string33 = bigDecimal3.multiply(bigDecimal4).toString();
		// String multiply = solution.multiply(ss1, ss2);
		// boolean b = string33.equalsIgnoreCase(multiply);
		// if (!b) {
		// // 不相同
		// System.out.println("wrong");
		// System.out.println(String.format("s1 %s s2 %s", ss1, ss2));
		// }
		// }
		// System.out.println(String.format("执行到 %s", i));
		// }
		// System.out.println(String.format("finish %s", (System.currentTimeMillis() - begin) / 1000 / 60));
	}
}
