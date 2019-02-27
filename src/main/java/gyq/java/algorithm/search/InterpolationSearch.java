package gyq.java.algorithm.search;

/**
 * 插值查找 现在我们的新问题是，为什么一定要折半，而不是折四分之一或者折更多呢?
 * 
 * 打个比方，在英文词典里查"apple"，你下意识里翻开词典是翻前面的书页还是后面的书页呢?如果再让你查"zoo"，你又怎么查?很显然，这里你绝对不会是从中间开始查起，而是有一定目的的往前或往后翻。 同样的，比如要在取值范围0 -
 * 10000之间100个元素从小到大均匀分布的数组中查找5，我们自然会考虑从数组下标较小的开始查找。 看来，我们的折半查找，还是有改进空间的。折半计算mid的公式，我们略微等式变换后得到:
 *
 * mid = (low+high)/2 = low + (high-low)/2
 *
 * 也就是mid等于最低下标low加上最高下标high与low的差的一半。算法科学家们考虑的就是将这个 1/2 进行改进，通过类比，改进为下面的计算方案: 
 *
 * mid = low + ((key - a[low])/(a[high] - a[low]))(high - low)
 *
 * 这样就可以大大提高查找的效率。
 *
 * 插值查找(Interpolation Search)是根据要查找的关键字 key 与查找表中最大最小记录的关键字比较后的查找方法，
 * 
 * 其核心就在于插值的计算公式(key - a[low])/(a[high] - a[low])。应该说，从时间复杂度来看，它也是O(logn)，
 * 
 * 但对于表长较大，而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好得多 。
 * 
 * 反之， 数组中如果分布类似{0，1，2，2000，2001，.......,999998, 999999}这种极端不均匀的数据，用插值查找未必是很合适的选择。
 * 
 * Created by ge_yi on 2019/2/27.
 */
public class InterpolationSearch {
	/**
	 * 插值查找, 可以理解为二分查找的优化版
	 *
	 * @param a
	 *            数组
	 * @param key
	 *            待查找关键字
	 * @return 返回折半下标， -1表示不存在该关键字
	 */
	public static int interpolationSearch(int[] a, int key) {
		int low, mid, high;
		low = 0;// 最小下标
		high = a.length - 1;// 最大小标
		while (low < high) {
			// 注意: (key - a[low]) / (a[high] - a[low]) 就是算出来的变化的比例,
			// 要查找的key越接近a[low], 得到的值越接近于0, 下一次的mid就越接近于现在的low
			mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);
			// mid = (high + low) / 2;// 折半下标
			if (key > a[mid]) {
				low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
			} else if (key < a[mid]) {
				high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
			} else {
				return mid; // 当 key == a[mid] 返回 折半下标
			}
		}
		return -1;
	}
}
