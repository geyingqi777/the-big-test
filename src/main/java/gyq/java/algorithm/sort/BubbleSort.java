package gyq.java.algorithm.sort;

import java.util.List;

/**
 * 冒泡排序 时间复杂度O(n^2)
 * 
 * @see SortAlgorithm
 */

class BubbleSort implements SortAlgorithm {
	/**
	 * This method implements the Generic Bubble Sort
	 *
	 * @param array
	 *            The array to be sorted Sorts the array in increasing order
	 **/

	@Override
	public <T extends Comparable<T>> T[] sort(T array[]) {
		int last = array.length;
		// Sorting
		boolean swap;
		do {
			swap = false;
			for (int count = 0; count < last - 1; count++) {
				if (SortUtils.less(array[count], array[count + 1])) {
					swap = SortUtils.swap(array, count, count + 1);
				}
			}
			last--;
		} while (swap);
		return array;
	}

	public static void sort2(List<Integer> list) {
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
	// TODO: 2019/2/27 冒泡排序的优化版实现

	// Driver Program
	public static void main(String[] args) {

		// Integer Input
		Integer[] integers = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(integers);

		// Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
		SortUtils.printObjArray(integers);

		// String Input
		String[] strings = { "c", "a", "e", "b", "d" };
		// Output => e, d, c, b, a
		SortUtils.printObjArray(bubbleSort.sort(strings));

	}
}
