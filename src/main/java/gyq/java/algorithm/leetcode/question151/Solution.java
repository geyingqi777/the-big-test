package gyq.java.algorithm.leetcode.question151;

/**
 * 翻转字符串里的单词 Created by ge_yi on 2019/2/19.
 */
public class Solution {
	/**
	 * 给定一个字符串，逐个翻转字符串中的每个单词。
	 *
	 * 示例:
	 *
	 * 输入: "the sky is blue",
	 * 
	 * 输出: "blue is sky the".
	 * 
	 * 说明:
	 *
	 * 无空格字符构成一个单词。
	 * 
	 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
	 * 
	 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if (s == null || "".equals(s.trim())) {
			return "";
		}
		String[] split = s.split(" ");
		String result = "";
		int length = split.length;
		for (int i = 0; i < length; i++) {
			String s1 = split[length - 1 - i];
			if (s1.length() > 0) {
				result = result + s1 + " ";
			}
		}
		int lastIndex = result.lastIndexOf(" ");
		if (lastIndex > 0) {
			result = result.substring(0, lastIndex);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String theSkyIsBlue = solution.reverseWords("the sky is blue");
		System.out.println(theSkyIsBlue + "end");
	}
}
