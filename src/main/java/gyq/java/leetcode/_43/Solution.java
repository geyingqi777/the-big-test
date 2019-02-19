package gyq.java.leetcode._43;

import java.math.BigDecimal;

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
		// 这个题的解决思路是模拟小学乘法竖式的方式,
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
		// 列数加1的原因: 每一次j循环完了之后,得到的数字位数可能为length2和length1中较大的再多一位
		int rowCount = lengthLonger + 1;// 列数
		// lineCount行rowCount列元素的二维数组
		int[][] array = new int[lineCount][rowCount];
		// 外层循环,在小学乘法竖式中,放在下面
		for (int i = lengthShorter - 1; i >= 0; i--) {
			int position10 = 0;
			int position100 = 0;
			// 内层循环,在乘法竖式中,放在上面
			for (int j = lengthLonger - 1; j >= 0; j--) {
				char c = numLonger.charAt(j);
				// 通过和字符'0'的差值,得到该位的int数值
				int n1 = c - '0';
				char c1 = numShorter.charAt(i);
				// 得到该位的int数值
				int n2 = c1 - '0';
				int multiply = n1 * n2 + position10;
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
		// // 打印一行看下
		// System.out.println(JSON.toJSONString(ints));
		// }

		// 最后把二维数组按列相加, 此处还是不能用int直接相加,可能会溢出
		// 外层循环是列
		StringBuilder stringBuilder = new StringBuilder();
		int position10 = 0;
		int position100 = 0;
		int position1000 = 0;
		for (int i = 0; i < rowCount + lineCount; i++) {
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
			sum = sum + position100 + position10;
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

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s2 = "401716832807512840963";
		String s1 = "167141802233061013023557397451289113296441069";
		String multiply = solution.multiply(s1, s2);
		System.out.println(multiply);
		BigDecimal bigDecimal = new BigDecimal(s1);
		BigDecimal bigDecimal1 = new BigDecimal(s2);
		System.out.println(bigDecimal.multiply(bigDecimal1).toString());
	}
}
