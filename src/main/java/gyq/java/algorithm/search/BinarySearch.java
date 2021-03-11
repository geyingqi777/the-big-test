package gyq.java.algorithm.search;

/**
 * 二分查找,折半查找 Created by ge_yi on 2019/2/27.
 */
public class BinarySearch implements SearchAlgorithm {
    /**
     * 折半查找
     * <p>
     * 首先，我们将数组的查找过程绘制成一棵二叉树，如果查找的关键字不是中间记录的话，折半查找等于是把静态有序
     * <p>
     * 查找表分成了两棵子树，即查找结果只需要找其中的一半数据记录即可，等于工作量少了一半，然后继续折半查找，效率当然是非常高了。
     * <p>
     * 根据二叉树的性质4，具有n个结点的完全二叉树的深度为[log2n]+1。在这里尽管折半查找判定二叉树并不是完全二叉树，
     * <p>
     * 但同样相同的推导可以得出，最坏情况是查找到关键字或查找失败的次数为[log2n]+1，最好的情况是1次。
     * <p>
     * 因此最终我们折半算法的时间复杂度为O(logn)，它显然远远好于顺序查找的O(n)时间复杂度了。
     * <p>
     * 不过由于折主查找的前提条件是需要有序表顺序存储，对于静态查找表，一次排序后不再变化，这样的算法已经比较好了。但对于需要频繁执行插入或删除操作的数据集来说，维护有序的排序会带来不小的工作量，那就不建议使用。
     *
     * @param array 数组 必须保证是有序的
     * @param key   待查找关键字
     * @return 返回折半下标， -1表示不存在该关键字
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int low, mid, high;
        low = 0;// 最小下标
        high = array.length - 1;// 最大小标
        while (low <= high) {
            mid = (high + low) / 2;// 折半下标
            int compareTo = key.compareTo(array[mid]);
            if (compareTo > 0) {
                low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
            } else if (compareTo < 0) {
                high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
            } else {
                return mid; // 当 key == a[mid] 返回 折半下标
            }
        }
        return -1;
    }
}
