package gyq.java.algorithm.sort;

/**
 * 计数排序 Created by ge_yi on 2019/2/20.
 */
public class CountSort {

    private void sort(int[] array) {
        // 先找到最大最小值
        int max = array[0];
        int min = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        sort(array, min, max);
    }

    /**
     * 此方法需要事先找出数组中的最大值和最小值
     *
     * @param array 原数组
     * @param min   原数组中的最小值
     * @param max   原数组中的最大值
     * @return
     */
    private int[] sort(int[] array, int min, int max) {
        int tempLength = max - min;// 得到最大值最小值的差
        int[] tempArray = new int[tempLength + 1];// 一个临时数组
        for (int t : array) {
            int i = t - min;
            // 每个元素和最小值的差距，就是临时数组中的索引位置,该位置的计数加1
            tempArray[i]++;
        }
        // 最后把数据放回原数组
        int index = 0;
        for (int i = 0; i < tempArray.length; i++) {
            int i1 = tempArray[i];
            for (int i2 = 0; i2 < i1; i2++) {
                array[index] = min + i;
                index++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        // Integer Input
        int[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        CountSort sort = new CountSort();
        sort.sort(arr);
        // Output => 1 4 6 9 12 23 54 78 231
        SortUtils.printObject(arr);

    }
}
