package gyq.java.langtest;

import java.util.ArrayList;
import java.util.List;

public class Java8Test {
	public static void main(String[] args) {
		System.out.println(null instanceof Integer);
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		for (Integer integer : integers) {
			System.out.println(integers.stream().findAny().get());
		}
	}
}
