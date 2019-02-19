package gyq.java.algorithm.leetcode.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序 Created by Asa on 2019-02-18.
 */
public class BubbleSort {
	public static void sort(List<Integer> list) {
		int size = list.size();
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1; j++) {
				int value1 = list.get(j);
				int value2 = list.get(j + 1);
				if (value2 > value1) {
					// 大的在前，小的在后
					int temp = value1;
					list.set(j, value2);
					list.set(j + 1, temp);
				}
			}
		}
	}
	// TODO: 2019-02-19 冒泡排序效率优化版 

	public static void main(String[] args) {
		List<Integer> arrayList = new LinkedList<>();
		for (int i = 0; i < 20; i++) {
			int i1 = new Random().nextInt(20);
			arrayList.add(i);
		}
		System.out.println(JSON.toJSONString(arrayList));
		BubbleSort.sort(arrayList);
		System.out.println(JSON.toJSONString(arrayList));
	}
}
