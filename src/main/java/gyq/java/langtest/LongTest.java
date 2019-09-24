package gyq.java.langtest;

import java.util.Date;

/**
 * @author Asa
 * @version 创建时间：2016年8月24日 下午6:38:52
 */
public class LongTest {
	public static void main(String[] args) {
		// String string = Long.toBinaryString(-9218868437227405312L);
		// System.out.println(string);
		// System.out.println(string.split("").length);
		// String string2 = Long.toBinaryString(9218868437227405312L);
		// System.out.println(string2);
		// System.out.println(string2.split("").length);

		String binaryString = "01111111111111111111111111111111111111111111111111111";
		long parseLong = Long.parseLong(binaryString, 2);
		System.out.println(parseLong);
		String string3 = Long.toHexString(562949963760995L);

		System.out.println(string3);// 1111111111111111111111111111111111111111111111111111
		System.out.println(string3.split("").length);

		String string4 = Long.toBinaryString(4503599627370496L);
		System.out.println(string4);
		System.out.println(string4.split("").length);

		String string5 = Long.toBinaryString(-4503599627370495L);
		System.out.println(string5);
		System.out.println(string5.split("").length);

		long ttt = Long.MAX_VALUE;
		float fff = 0.333f;
		System.out.println((long) (ttt * fff));

		int aaa = Integer.MAX_VALUE;
		System.out.println(aaa);

		Long testLong = new Long(1);
		System.out.println(testLong == 2);
		System.out.println(Long.MAX_VALUE);

		System.out.println(new Date(1483093284027L));

		int score = 1;
		double score1 = score;
		System.out.println(score1);
	}
}
