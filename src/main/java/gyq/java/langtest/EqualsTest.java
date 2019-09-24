package gyq.java.langtest;

public class EqualsTest {
	public static void main(String[] args) {
		Long long1 = new Long(123);
		Long long2 = new Long(123);
		long long3 = 123l;
		System.out.println(long1 == long2);
		System.out.println(long2 == long3);
		System.out.println(long1.equals(long3));
		System.out.println(long1.equals(long2));
	}
}
