package gyq.java.algorithm.leetcode.p35_search_insert_position;

/**
 * 35. 搜索插入位置
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/search-insert-position/
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        // nums已升序排序
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            // 考虑到可能发生的整型溢出，使用 left + (right - left)/2 取mid更安全一点。
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 找到目标,返回下标
                return mid;
            } else if (nums[mid] < target) {
                // 中间小于目标
                left = mid + 1;
            } else {
                // 中间大于目标
                right = mid - 1;
            }
        }
        // 没找到, 返回left就是插入位置
        return left;

    }
}