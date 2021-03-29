package gyq.java.algorithm.leetcode.p33_search_in_rotated_sorted_array;

/**
 * 33. 搜索旋转排序数组
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 先找到k的值
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // 最小值在右半区间,且mid不是最小值
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 最小值在左边,mid也有可能
                right = mid;
            }
        }
        // 这时left就是原数组第一个,最小值
        if (left == 0) {
            // 这个是没有旋转的情况
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if (target == nums[0]) {
            return 0;
        } else if (target > nums[0]) {
            // n = num.length
            // 在原数组的k到n-1的范围内二分查找, 也就是当前数组的0到 n - 1 - k的范围
            return binarySearch(nums, 0, left - 1, target);
        } else {
            // 在原数组的0到k-1范围内查找, 也就是当前数组的n - k 到 n - 1
            return binarySearch(nums, left, nums.length - 1, target);
        }
    }

    private int binarySearch(int[] num, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}