package gyq.java.langtest;

import java.util.Date;

public class NewDateTest {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 1000000; i++) {
			new Date();
		}
		System.out.println(System.currentTimeMillis());
	}
}
