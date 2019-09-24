package gyq.java.langtest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Asa
 * @version 创建时间：2016年7月26日 下午3:31:02
 */
public class MapTest {
	private static Person person = new Person();

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Map<String, Object> resultMap = new HashMap<>(2, 1.1f);
		resultMap.put("1", "1");
		resultMap.put("2", "2");
		resultMap.put("3", "3");
		resultMap.put("4", "4");
		System.out.println(resultMap.size());
		System.out.println(System.currentTimeMillis());

		Map<Integer, Person> personHashMap = new HashMap<>();
		Map<Integer, Person> personHashMap2 = new HashMap<>();
		personHashMap.put(1, person);
		personHashMap.put(2, person);
		personHashMap2.put(2, person);
		Person person = personHashMap.get(1);
		Person person1 = personHashMap.get(2);
		Person person2 = personHashMap2.get(2);
		person.setAge(3);
		System.out.println(person1.getAge());
		System.out.println(person2.getAge());
		System.out.println(person.hashCode());
		System.out.println(person1.hashCode());
		System.out.println(person1.equals(person));
	}
}
