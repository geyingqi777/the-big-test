package gyq.java.leetcode._3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串 Created by ge_yi on 2019/2/18.
 */
class Solution {
	public int lengthOfLongestSubstring(String source) {
		// 最差的时间复杂度O(n^2) 空间复杂度O(1)
		// 判断是否为空
		if (source == null) {
			return 0;
		}
		int length = source.length();
		if (length <= 1) {
			// 长度如果小于等于1，子串就是自己
			return source.length();
		}
		// 用于保存最终结果
		int left = 0;
		int right = 0;
		int maxLength = 0;
		HashSet<Character> charactersSet = new HashSet<>();
		// 从左到右遍历这个string里的字符
		while (right < length) {
			char rightChar = source.charAt(right);
			if (!charactersSet.contains(rightChar)) {
				// 未出现过这个字符
				// 判断临时区域是否比原来的长了
				charactersSet.add(rightChar);
				right++;
				maxLength = Math.max(maxLength, charactersSet.size());
			} else {
				// 已经包含这个字符,从left开始删
				charactersSet.remove(source.charAt(left));
				left++;
			}
		}
		// 遍历完一遍之后得到的pre和post中间就是最长无重复子串
		return maxLength;
	}

	/**
	 * 另一种思路
	 * 
	 * @param source
	 * @return
	 */
	public int lengthOfLongestSubstring2(String source) {
		// 时间复杂度O(n) 空间复杂度O(1)
		if (source == null) {
			return 0;
		}
		HashMap<Character, Integer> hashMap = new HashMap<>();
		int res = 0, left = 0;
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			Integer index = hashMap.get(c);
			if (index != null) {
				// 如果出现过,则从 最后一次出现的下标加1的位置 和 当前left的位置中，选择更大的位置
				left = Math.max(left, index + 1);
			}
			// 最大长度， 从之前达到过的最大长度和当前字符串的长度中取较大的
			res = Math.max(res, i - left + 1);
			// 保存这个字符最后一次出现的下标
			hashMap.put(c, i);
		}
		return res;
	}

	/**
	 * 测试入口
	 * 
	 * @param testCases
	 * @return
	 */
	public static void testDoor(String[] testCases) {
		Solution solution = new Solution();
		for (String testCase : testCases) {
			int lengthOfLongestSubstring = solution.lengthOfLongestSubstring(testCase);
			System.out.println(String.format("Case %s Result %s", testCase, lengthOfLongestSubstring));
		}
		System.out.println("-----------------------------------");
		for (String testCase : testCases) {
			int lengthOfLongestSubstring = solution.lengthOfLongestSubstring2(testCase);
			System.out.println(String.format("Case %s Result %s", testCase, lengthOfLongestSubstring));
		}
	}

	public static void main(String[] args) {
		String[] testCases = new String[] { "abcabcbb", "bbbbb", "pwwkew", "Abcabcbb", "", " ", "  ", null };
		testDoor(testCases);
	}
}
