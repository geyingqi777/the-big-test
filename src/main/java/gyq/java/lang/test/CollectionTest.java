package gyq.java.lang.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Asa
 * @version 创建时间：2016年7月26日 下午3:45:14
 */
public class CollectionTest {
	public static void main(String[] args) {

		Set<Integer> set1 = new HashSet<>();
		set1.add(2);
		set1.add(1);
		Set<Integer> set2 = null;
		if (set2 == null) {
			set2 = Collections.emptySet();
		}
		set1.removeAll(set2);
		for (Integer integer : set1) {
			System.out.println(integer);
		}

		List<Integer> list2 = new ArrayList<>();
		// list.addAll(null);
		list2.add(2);
		list2.add(1);
		list2.removeAll(set1);
		System.out.println(list2.isEmpty());

		// Collections.sort(list2);
		// list2=list2.stream().sorted((x,y)-> x.compareTo(y)).collect(Collectors.toList());
		// for (Integer integer : list2) {
		// System.out.println(integer);
		// }
		// FarmBuildingConfig farmBuildingConfig1 = configMap.get("1");
		// farmBuildingConfig.setX(1);
		// System.out.println(configMap.get("1").getX());
		//
		// System.out.println(list.get(0).getX());

		int continuousCount = 1;// 连续天数
		List<Integer> resultList = new ArrayList<Integer>();
		resultList.add(1);
		resultList.add(2);
		resultList.add(3);
		Collections.sort(resultList);
		int lastId = resultList.get(0);
		// 每次判断取出来的是不是上一个id+1，如果不是的话，连续天数设置成1，如果是的话连续天数+1
		for (int index = 1; index < resultList.size(); index++) {
			int idIndex = resultList.get(index);
			if (lastId + 1 == idIndex) {
				continuousCount++;
			} else {
				continuousCount = 1;
			}
		}
		System.out.println(continuousCount);

		System.out.println(System.currentTimeMillis());
		// 测试一下求合集差集
		Set<Long> userIdsSignIn2DaysAgo = new HashSet<>();
		Set<Long> userIdsSignIn1DaysAgo = new HashSet<>();
		Set<Long> userIdsSignIn0DaysAgo = new HashSet<>();
		for (long i = 0; i < 700000; i++) {
			userIdsSignIn2DaysAgo.add(i);
		}
		for (long i = 500000; i < 1000000; i++) {
			userIdsSignIn1DaysAgo.add(i);
		}

		for (long i = 0; i < 600000; i++) {
			userIdsSignIn0DaysAgo.add(i);
		}
		System.out.println(System.currentTimeMillis());
		userIdsSignIn2DaysAgo.retainAll(userIdsSignIn1DaysAgo);
		System.out.println(userIdsSignIn2DaysAgo.size());
		userIdsSignIn2DaysAgo.removeAll(userIdsSignIn0DaysAgo);
		System.out.println(userIdsSignIn2DaysAgo.size());
		System.out.println(System.currentTimeMillis());

		DateTest test = new DateTest();
		test.invokeTest();

	}
}
