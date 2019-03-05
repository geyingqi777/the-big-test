package gyq.java.lang.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<Father> fathers = new ArrayList<Father>();
		// fathers.addAll(null); NullPointerException
		fathers.add(null);
		System.out.println(fathers.size());
		// Child child = new Child();
		// fathers.add(child);
		//// for (Father father : fathers) {
		//// father.setName("名字");
		//// }
		// fathers.stream().forEach(father->father.setName("名字"));
		// for (Father father : fathers) {
		// System.out.println(father.getName());
		// }
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new LinkedList<>();
		List<Integer> list3 = new ArrayList<>();
		list1.addAll(list2);
		list2.addAll(list1);
		int indexOf = list1.indexOf(1);
		System.out.println(indexOf);

	}
}

class Father {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Child extends Father {

}
