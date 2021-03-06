package gyq.java.algorithm.sort;

/**
 * 快速排序 时间复杂度为O(nlogn)
 * <p>
 * 算法思想：基于分治的思想，是冒泡排序的改进型。
 * <p>
 * 首先在数组中选择一个基准点（该基准点的选取可能影响快速排序的效率，选取的方法可优化），
 * <p>
 * 然后分别从数组的两端扫描数组，设两个指示标志（lo指向起始位置，hi指向末尾)，
 * <p>
 * 首先从后半部分开始，如果发现有元素比该基准点的值小，就交换lo和hi位置的值，
 * <p>
 * 然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，
 * <p>
 * 如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置。一次排序就完成了。
 * <p>
 * 以后采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
 * <p>
 * Created by ge_yi on 2019/2/27.
 */
public class QuickSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 快速排序的一遍循环
     *
     * @param unsorted
     * @param lowOrigin
     * @param highOrigin
     * @param <T>
     * @return
     */
    private <T extends Comparable<T>> T[] quickSort(T[] unsorted, int lowOrigin, int highOrigin) {
        if (lowOrigin >= highOrigin) {
            // 排序结束
            return unsorted;
        }
        // 基准值
        int baseIndex = lowOrigin;
        T base = unsorted[baseIndex];
        // 赋值给临时变量
        int low = lowOrigin;
        int high = highOrigin;
        while (high > low) {
            while (unsorted[high].compareTo(base) >= 0 && high > low) {
                // 直到找到unsorted[high]的值小于base
                high--;
            }
            while (unsorted[low].compareTo(base) <= 0 && high > low) {
                // 直到找到unsorted[low]的值大于base
                low++;
            }
            // 交换他俩的位置
            if (low < high) {
                SortUtils.swap(unsorted, low, high);
            }
        }
        // 循环完了, 此时low==high,最后把base值和该位置交换, 一遍排序就完成了,
        // 此时, base左边的都是比他小的, 右边都是比他大的
        SortUtils.swap(unsorted, baseIndex, high);
        // 把每一遍排序之后的结果打印一下
        SortUtils.printObjArray(unsorted);
        // 递归排序左半边数组
        quickSort(unsorted, lowOrigin, high - 1);
        // 排序右半边数组
        quickSort(unsorted, high + 1, highOrigin);
        return unsorted;
    }

    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        QuickSort sort = new QuickSort();

        sort.sort(integers);

        // Output => 1 4 6 9 12 23 54 78 231
        SortUtils.printObject(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};

        sort.sort(strings);

        // Output => a b c d e
        SortUtils.printObject(strings);
    }
}
