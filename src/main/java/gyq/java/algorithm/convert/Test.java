package gyq.java.algorithm.convert;

/**
 * 给一个数组
 *  [567 1234], 原来是升序的, 
 *  查找一个数字,返回指定下标, 没有返回-1
 * @author geyingqi
 * @date 2021/4/15 5:59 下午
 */
public class Test {
    
    private int find(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > array[right]) {
                // 中间值在左半边数组
                if (array[mid] < target) {
                    // target一定在左半边
                    left = mid + 1;
                } else {
                    // target可能在left-mid 或者右半边数组
                    
                } 
            }
            if (array[mid] < right) {
                // mid是数组的右半边
                if (array[mid] > target) {
                    // target在左边
                    right = mid - 1;
                } else {
                    // target可能在mid-right 或者左半边
                    
                } 
            }
        }
    }
}
