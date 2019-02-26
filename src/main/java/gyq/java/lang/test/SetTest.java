package gyq.java.lang.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Asa
 * @version 创建时间：2016年9月18日 下午3:42:52
 */
public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>(2);
		List<String> list = new ArrayList<>(2);
		System.out.println(set.size());
		System.out.println(list.size());
	}
}
