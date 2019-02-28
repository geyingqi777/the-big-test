package gyq.java.algorithm.sort;

/**
 * 归并排序
 * 
 * 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。
 * 
 * java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
 * 
 * 每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。
 * 
 * 总的平均时间复杂度为O(nlogn)。
 * 
 * 而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
 * 
 * 网上一篇讲得很好的文章: http://www.cnblogs.com/chengxiao/p/6194356.html
 * 
 * Created by ge_yi on 2019/2/28.
 */
public class MergeSort implements SortAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		int length = unsorted.length;
		// 这里声明一个和原来数组一样长度的数组,就不需要其他空间了
		// 泛型数组的创建方式貌似只能强制转换一下
		T[] temp = (T[]) new Comparable[length];
		return mergeSort(unsorted, 0, length - 1, temp);
	}

	private <T extends Comparable<T>> T[] mergeSort(T[] array, int left, int right, T[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 递归排序左半边
			mergeSort(array, left, mid, temp);
			// 递归排序右半边
			mergeSort(array, mid + 1, right, temp);
			merge(array, left, mid, right, temp);
		}
		return array;
	}

	/**
	 * 合并数组的逻辑,执行merge之前, 需要确保 {@param array}的左半右半边都各自是有序的
	 * 
	 * @param array
	 * @param left
	 * @param mid
	 * @param right
	 * @param temp
	 * @param <T>
	 * @return
	 */
	private <T extends Comparable<T>> T[] merge(T[] array, int left, int mid, int right, T[] temp) {
		int i = left; // 左半部分的索引
		int j = mid + 1; // 右半部分的索引
		int k = 0;// 临时数组的索引
		while (i <= mid && j <= right) {
			// 升序
			// 把原数组的值,填进新数组
			if (array[i].compareTo(array[j]) > 0) {
				temp[k] = array[j];
				j++;
			} else {
				temp[k] = array[i];
				i++;
			}
			k++;
		}
		// 上面循环完了之后,要么是左边遍历完了,要么是右边遍历完了
		while (i <= mid) {
			// 左边还需要继续遍历
			temp[k] = array[i];
			k++;
			i++;
		}
		while (j <= right) {
			// 右边还需要继续遍历
			temp[k] = array[j];
			k++;
			j++;
		}
		// 把填完的temp数组填回原数组, 只需要填从left到right的
		for (int i1 = left; i1 <= right; i1++) {
			array[i1] = temp[i1];
		}
		return array;
	}

	public static void main(String[] args) {
		// Integer Input
		Integer[] arr = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr);

		// Output => 1 4 6 9 12 23 54 78 231
		SortUtils.printObject(arr);

		// String Input
		String[] stringArray = { "c", "a", "e", "b", "d" };
		mergeSort.sort(stringArray);
		// Output => a b c d e
		SortUtils.printObject(stringArray);
	}
}
