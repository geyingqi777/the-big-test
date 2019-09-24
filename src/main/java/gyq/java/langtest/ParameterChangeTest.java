package gyq.java.langtest;

public class ParameterChangeTest {
	public static void main(String[] args) {
		int i = 1;
		boolean b = false;
		long l = 1L;
		Integer integer = 1;
		Boolean boolean1 = false;
		Long long1 = 1L;
		Integer integer2 = new Integer(1);
		StringBuilder stringBuilder = new StringBuilder();
		change(i, b, l, integer2, boolean1, long1, stringBuilder);
		System.out.println(String.format("int:%s,boolean:%s,long:%s,Integer:%s,Boolean:%s,Long:%s,StringBuilder:%s", i, b, l, integer2, boolean1,
				long1, stringBuilder));
	}

	private static void change(int i, boolean b, long l, Integer integer, Boolean boolean1, Long long1, StringBuilder stringBuilder) {
		i = 2;
		b = true;
		l = 2L;
		integer = new Integer(2);
		boolean1 = true;
		long1 = 2L;
		stringBuilder.append("change");
	}
}
