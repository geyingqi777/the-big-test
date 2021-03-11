package gyq.java.algorithm.search;

/**
 * 顺序查找 Created by ge_yi on 2019/2/27.
 */
public class SequentialSearch implements SearchAlgorithm {

    /**
     * 有哨兵顺序查找(大型数据顺序查找的优化版)
     * <p>
     * 这种在查找方向的尽头放置"哨兵"免去了在查找过程中每一次比较后都要判断查找位置是否越界的小技巧，看似与原先差别不大，
     * <p>
     * 但在总数据较多时，效率提高很大，是非常好的编码技巧。当然，"哨兵"也不一定就一定要在数组开始，也可以在末端。
     * <p>
     * 对于这种顺序查找算法来说，查找成功最好的情况就是在第一个位置就找到了，算法时间复杂度为O(1)，
     * <p>
     * 最坏的情况是在最后一位置才找到，需要n次比较，时间复杂度为O(n)，当查找不成功时，需要n+1次比较，时间复杂度为O(n)。
     * <p>
     * 我们之前推导过，关键字在任何一位置的概率是相同的，所以平均查找次数为(n+1)/2 ，所以最终时间复杂度还是O(n)。
     * <p>
     * 很显然，顺序查找技术是有很大缺点的，n很大时，查找效率极为低下，
     * <p>
     * 不过优点也是有的，这个算法非常简单，对静态查找表的记录没有任何要求，在一些小型数据的查找时，是可以适用的。
     * <p>
     * 另外，也正由于查找概率的不同，我们完全可以将容易查找到的记录放在前面，而不常用的记录放置在后面，效率就可以有大幅提高
     *
     * @param a   数组(下标为0存放哨兵元素)
     * @param key 待查询关键字
     * @return 关键字下标 返回0 则未找到
     */
    public static int find2(int[] a, int key) {
        int index = a.length - 1;
        // 注意: 这种哨兵的方式,需要数组查找方向尽头留出一个位置,设置哨兵之前不能有元素
        a[0] = key;// 将下标为0的数组元素设置为哨兵
        while (a[index] != key) {
            index--;
        }
        return index;
    }

    /**
     * 顺序查找(适用于小型数据)
     *
     * @param array 数组
     * @param key   待查找关键字
     * @return 关键字下标
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key))
                return i;
        }
        return -1;
    }
}
