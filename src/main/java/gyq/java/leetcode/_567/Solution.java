package gyq.java.leetcode._567;

import java.util.Arrays;

/**
 * 字符串的排列 Created by ge_yi on 2019/2/18.
 */
class Solution {
	/**
	 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
	 *
	 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。 示例1:
	 *
	 * 输入: s1 = "ab" s2 = "eidbaooo" 输出: True 解释: s2 包含 s1 的排列之一 ("ba").
	 *
	 *
	 * 示例2:
	 *
	 * 输入: s1= "ab" s2 = "eidboaoo" 输出: False
	 *
	 *
	 * 注意：
	 *
	 * 输入的字符串只包含小写字母 两个字符串的长度都在 [1, 10,000] 之间
	 * 
	 * @return
	 */
	public boolean checkInclusion(String s1, String s2) {
		// 首先字符串s1的排列的可能性应该是它的长度的阶乘，
		// 因为字符串长度可能为10000，所以找出所有排列情况是不太可能。
		// 我们可以转换思路，不要关注排列的形式，而是关注排列中元素的数量关系，比如aab，那么，转换为数量关系就是{a:2,b:1}，
		// 我们的窗口长度为S1长度，
		// 如果我们在S2的找到了这样一个窗口符合出现a的次数是两个，b是一个，那么S2就是包含S1的排列的。
		int l1 = s1.length();
		int l2 = s2.length();
		int[] c1 = new int[26]; // 26个小写英文字母
		int[] c2 = new int[26];
		// 首先统计出s1中每个字母出现的次数
		for (char c : s1.toCharArray())
			c1[c - 'a']++;

		// 然后遍历s2,执行一个滑动的统计区间,长度为l1
		for (int i = 0; i < l2; i++) {
			if (i >= l1) {
				// 如果已经超过s1的长度了,去掉滑动区间的首个字母,即其对应的数量减1
				c2[s2.charAt(i - l1) - 'a']--;
			}
			// 统计s2每个字母出现的次数
			c2[s2.charAt(i) - 'a']++;
			// 在区间滑动过程中,一旦出现字母数量都相同的情况,就可以判定包含子串
			if (Arrays.equals(c1, c2)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean checkInclusion2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() > s2.length()) {
			return false;
		}
		int[] count1 = new int[26]; // s1每个字符出现的次数
		int[] count2 = new int[26]; // s2每个字符出现的次数
		// 1. 进行统计
		for (int i = 0; i < s1.length(); i++) {
			count1[s1.charAt(i) - 'a']++;
			count2[s2.charAt(i) - 'a']++;
		}
		// 2. 滑动窗口，滑块长度始终为 s1.length()
		for (int i = s1.length(); i < s2.length(); i++) {
			if (isSame(count1, count2)) {
				return true;
			}
			count2[s2.charAt(i - s1.length()) - 'a']--; // 去掉滑块当前的首个字符
			count2[s2.charAt(i) - 'a']++; // 添加最新的字符到滑块中
		}
		return isSame(count1, count2);
	}

	// 有且仅当 count1 中所有值都等于 count2 中对应值时满足条件
	public static boolean isSame(int[] count1, int[] count2) {
		for (int i = 0; i < count1.length; i++) {
			if (count1[i] != count2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] testCases = new String[] { "ab", "eidbaooo" };
		Solution solution = new Solution();
		boolean checkInclusion = solution.checkInclusion(testCases[0], testCases[1]);
		System.out.println(checkInclusion);
	}
}
