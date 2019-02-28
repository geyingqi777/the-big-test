package gyq.java.algorithm.sort;

/**
 * 选择排序 时间复杂度O(n^2)
 * 
 * 简单选择排序是最简单直观的一种算法，基本思想为每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，直到所有元素排完为止，简单选择排序是不稳定排序。
 * 
 * 和冒泡排序相比,这种方式减少了很多无用的位置交换操作,效率更高了
 * 
 * Created by ge_yi on 2019/2/28.
 */
public class SelectionSort implements SortAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = i; // 最小值的位置从i开始
			for (int j = min + 1; j < array.length; j++) {
				// 比较min位置和之后的所有值,如果遇到更小的,就把位置赋值给min
				if (array[min].compareTo(array[j]) > 0) {
					min = j;
				}
			}
			// 把这一遍循环找到的最小值和i位置交换
			SortUtils.swap(array, min, i);
		}
		return array;
	}

	public static void main(String[] args) {
		// Integer Input
		Integer[] integers = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };

		SelectionSort sort = new SelectionSort();

		sort.sort(integers);

		// Output => 1 4 6 9 12 23 54 78 231
		SortUtils.printObject(integers);

		// String Input
		String[] strings = { "c", "a", "e", "b", "d" };

		sort.sort(strings);

		// Output => a b c d e
		SortUtils.printObject(strings);
	}
}
