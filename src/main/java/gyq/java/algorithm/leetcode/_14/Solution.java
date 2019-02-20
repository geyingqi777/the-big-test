package gyq.java.algorithm.leetcode._14;

/**
 * 最长公共前缀 Created by ge_yi on 2019/2/18.
 */
class Solution {
	/**
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
	 *
	 * 如果不存在公共前缀，返回空字符串 ""。
	 *
	 * 示例 1:
	 *
	 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
	 *
	 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
	 *
	 * 所有输入只包含小写字母 a-z 。
	 * 
	 * @param array
	 * @return
	 */
	public String longestCommonPrefix(String[] array) {
		int length = array.length;
		if (array == null || length == 0) {
			return "";
		}
		String s1 = array[0];
		if (array.length == 1) {
			return s1;
		}
		// 时间复杂度O(n^2)，执行太慢
		int i = 0;
		boolean flag = true;
		while (flag) {
			if (s1.length() < i + 1) {
				flag = false;
				break;
			}
			char pre = s1.charAt(i);
			for (String s : array) {
				// 如果不一样了，或者长度不够了，跳出循环
				if (s.length() < i + 1 || s.charAt(i) != pre) {
					flag = false;
					break;
				}
			}
			if (flag) {
				i++;
			}
		}
		if (i == 0) {
			return "";
		} else {
			return s1.substring(0, i);
		}
	}

	/**
	 * 另一种思路
	 * 
	 * @param array
	 * @return
	 */
	public String longestCommonPrefix2(String[] array) {
		// 当array长度大于2的时候，可以先找到1和2中的公共前缀，然后再拿这个前缀去和后面的字符串比较
		return null;
	}

	public static void main(String[] args) {
		// String[] testCases = new String[] { "flower", "flow", "flight" };
		// String[] testCases = new String[] { "c", "c" };
		String[] testCases = new String[] { "", "" };
		Solution solution = new Solution();
		String s = solution.longestCommonPrefix(testCases);
		System.out.println(s);
	}
}
