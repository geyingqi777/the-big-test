package gyq.java.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 排序算法需要用到的工具类
 **/
final class SortUtils {

    /**
     * Helper method for swapping places in array
     *
     * @param array The array which elements we want to swap
     * @param idx   index of the first element
     * @param idy   index of the second element
     */
    static <T> boolean swap(T[] array, int idx, int idy) {
        T swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }

    /**
     * This method checks if first element is less then the other element
     *
     * @param v first element
     * @param w second element
     * @return true if the first element is less then the second element
     */
    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * Just print list
     *
     * @param toPrint - a list which should be printed
     */
    static void printList(List<?> toPrint) {
        // toPrint.stream().map(Object::toString).map(str -> str + " ").forEach(System.out::print);
        // System.out.println();
        System.out.println(JSON.toJSONString(toPrint));
    }

    /**
     * Prints an array
     *
     * @param toPrint - the array which should be printed
     */
    static void printObjArray(Object[] toPrint) {
        // System.out.println(Arrays.toString(toPrint));
        System.out.println(JSON.toJSONString(toPrint));
    }

    /**
     * 打印对象
     *
     * @param object
     */
    static void printObject(Object object) {
        System.out.println(JSON.toJSONString(object));
    }

    /**
     * Swaps all position from {@param left} to @{@param right} for {@param array}
     *
     * @param array is an array
     * @param left  is a left flip border of the array
     * @param right is a right flip border of the array
     */
    static <T extends Comparable<T>> void flip(T[] array, int left, int right) {
        while (left <= right) {
            swap(array, left++, right--);
        }
    }
}
