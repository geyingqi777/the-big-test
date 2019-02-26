package gyq.java.lang.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Asa
 * @version 创建时间：2016年7月27日 下午3:22:46
 */
public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		// for (String s : list) {
		// System.out.println(s);
		// if ("3".equals(s)) {
		// //这样子删倒数第二个元素，不会报错，但是却不会再有最后一次循环
		// list.remove(s);
		// }
		// }
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			System.out.println(s);
			if ("3".equals(s)) {
				iterator.remove();
				// list.remove(s);
			}
		}
		for (String string : list) {
			System.out.println(string);
		}
	}
}
