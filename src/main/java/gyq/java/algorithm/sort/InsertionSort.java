package gyq.java.algorithm.sort;

/**
 * 插入排序 时间复杂度O(n^2)
 * 
 * 直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 * 
 * 和冒泡排序的区别是, 冒泡排序的内外层遍历顺序是一样的, 都是从左到右
 * 
 * 而插入排序的遍历顺序,外层从左到右,内层从右到左, 内层遍历起始位置是外层当前的位置
 * 
 * 参考文章,图文讲解hin好: http://www.cnblogs.com/chengxiao/p/6103002.html
 * 
 * Created by ge_yi on 2019/2/28.
 */
public class InsertionSort implements SortAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] array) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			// 外层从左到右，遍历i到length之间的数据
			for (int j = i; j > 0; j--) {
				// 内层遍历索引0到索引i之间的数据，从右到左遍历
				if (array[j].compareTo(array[j - 1]) < 0) {
					// 升序,大的放后面,
					// ps:个人感觉,这种排序方式之所以叫插入排序, 是因为交换位置的时候, 就像是把要排到前面的插队过去...感觉其实和冒泡排序相比没啥本质区别...
					SortUtils.swap(array, j, j - 1);
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {
		// Integer Input
		Integer[] integers = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };

		InsertionSort sort = new InsertionSort();

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
