package gyq.java.lang.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Asa on 2016/11/22.
 */
public class RegexTest {
	public static void main(String[] args) {
		final Pattern pattern1 = Pattern.compile("\\{[0-9]*\\}");
		final Pattern pattern2 = Pattern.compile("_[0-9]*_");
		String testString = "{166666661}_23333332_os";
		Matcher matcher1 = pattern1.matcher(testString);
		Matcher matcher2 = pattern2.matcher(testString);
		long loveSpaceId = 0;
		long userId = 0;
		matcher1.find(0);
		String rs = matcher1.group(0);
		loveSpaceId = Long.parseLong(rs.substring(1, rs.length() - 1));
		while (matcher2.find()) {
			rs = matcher2.group(0);
			userId = Long.parseLong(rs.substring(1, rs.length() - 1));
		}
		System.out.println("loveSpaceId:" + loveSpaceId + "_userId:" + userId);

		String s = "aab";// .*b*c*c
		String p = "c*a*b";// bc
		System.out.println(isMatch(s, p));
	}

	/**
	 * s could be empty and contains only lowercase letters a-z. p could be empty and contains only lowercase letters a-z, and characters like . or *.
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if (p.contains(".") || p.contains("*")) {
			// 遍历一遍p字符串的char,去检查s中是否满足
			int lastSIndex = 0;
			char lastSChar = '\0';
			int lastPIndex = 0;
			char duplicateSChar = '\0';
			char afterDuplicateSChar = '\0';
			while (lastPIndex < p.length()) {
				char c = p.charAt(lastPIndex);
				if (lastSIndex >= s.length()) {
					// index超过s的长度了,如果p还有,则false
					if (lastPIndex + 1 < p.length()) {
						return false;
					} else {
						return true;
					}
				}
				char c1 = s.charAt(lastSIndex);
				if (c == '.') {
					if (c1 < 'a' || c1 > 'z') {
						return false;
					}
					lastPIndex++;
				} else if (c == '*') {
					if (duplicateSChar == '\0') {
						// 判断是*开始之后,保存一下要重复的字符
						duplicateSChar = lastSChar;
						if (lastPIndex + 1 < p.length()) {
							afterDuplicateSChar = p.charAt(lastPIndex + 1);
						}
						if (c1 != duplicateSChar && c1 != afterDuplicateSChar) {
							return false;
						}
					} else {
						if (lastPIndex + 1 >= p.length()) {
							// 遍历结束了
							lastPIndex++;
						}
						if (afterDuplicateSChar != '\0' && c1 == afterDuplicateSChar) {
							lastPIndex++;
						}
						if (c1 != duplicateSChar && c1 != afterDuplicateSChar) {
							return false;
						}
					}
					// 判断*之后是什么
				} else {
					if (c != c1) {
						// FIXME 观察c之后是不是*,如果是的话, 当前字符也许可以忽略,
						return false;
					}
					lastPIndex++;
				}
				lastSIndex++;
				lastSChar = c1;
			}
			return true;
		}
		return s.equals(p);
	}
}
