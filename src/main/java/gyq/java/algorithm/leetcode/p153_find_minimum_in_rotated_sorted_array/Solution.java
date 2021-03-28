package gyq.java.algorithm.leetcode.p153_find_minimum_in_rotated_sorted_array;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
class Solution {
    public int findMin(int[] nums) {
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
        return nums[left];
    }
}