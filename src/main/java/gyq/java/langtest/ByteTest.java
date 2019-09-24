package gyq.java.langtest;

import java.util.Arrays;

/**
 * @author Asa
 * @version 创建时间：2016年9月18日 下午3:42:52
 */
public class ByteTest {
	public static void main(String[] args) {
		byte[] bytes1 = new byte[1];
		byte[] bytes2 = new byte[2];
		System.out.println(bytes1 == bytes2);
		System.out.println(Arrays.equals(bytes1, bytes2));
	}
}
