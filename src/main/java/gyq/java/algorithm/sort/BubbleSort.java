package gyq.java.algorithm.sort;

/**
 * 冒泡排序 时间复杂度O(n^2)
 *
 * @see SortAlgorithm
 */

class BubbleSort implements SortAlgorithm {
    /**
     * This method implements the Generic Bubble Sort
     *
     * @param array The array to be sorted Sorts the array in increasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T array[]) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length - i; j++) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    SortUtils.swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序的优化1，加一个标记，如果某一遍循环之后，没有元素交换，说明已经排序完成了
     * <p>
     * 假设我们现在排序ar[]={1,2,3,4,5,6,7,8,10,9}这组数据，按照上面的排序方式，第一趟排序后将10和9交换已经有序，接下来的8趟排序就是多余的，什么也没做。
     * <p>
     * 所以我们可以在交换的地方加一个标记，如果那一趟排序没有交换元素，说明这组数据已经有序，不用再继续下去
     *
     * @param array
     * @param <T>
     * @return
     */
    public <T extends Comparable<T>> T[] sort1(T array[]) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            boolean swap = false;
            for (int j = 1; j < length - i; j++) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    SortUtils.swap(array, j, j - 1);
                    swap = true;
                }
            }
            if (!swap) {
                // 没有发生交换，已经有序了
                break;
            }
        }
        return array;
    }

    /**
     * 冒泡排序的优化2
     * <p>
     * 优化一仅仅适用于连片有序而整体无序的数据(例如：1， 2，3 ，4 ，7，6，5)。
     * <p>
     * 但是对于前面大部分是无序而后边小半部分有序的数据(1，2，5，7，4，3，6，8，9，10)排序效率也不可观，
     * <p>
     * 对于种类型数据，我们可以继续优化。既我们可以记下最后一次交换的位置，后边没有交换，必然是有序的，
     * <p>
     * 然后下一次排序从第一个比较到上次记录的位置结束即可。
     *
     * @param array
     * @param <T>
     * @return
     */
    public <T extends Comparable<T>> T[] sort2(T array[]) {
        int length = array.length;

        int endPostion = length; // 内层循环的结束索引位置
        int lastSwapPosition = 0;// 用来记录最后一次交换的位置
        for (int i = 0; i < length - 1; i++) {
            boolean swap = false;
            lastSwapPosition = 0;
            for (int j = 1; j < endPostion; j++) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    SortUtils.swap(array, j, j - 1);
                    swap = true;
                    lastSwapPosition = j;
                }
            }
            if (!swap) {
                // 没有发生交换，已经有序了
                break;
            }
            endPostion = lastSwapPosition;
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {

        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort2(integers);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        SortUtils.printObjArray(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        // Output => e, d, c, b, a
        SortUtils.printObjArray(bubbleSort.sort2(strings));

    }
}
