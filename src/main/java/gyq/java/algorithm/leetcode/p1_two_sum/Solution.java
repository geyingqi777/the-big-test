package gyq.java.algorithm.leetcode.p1_two_sum;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/two-sum/
 */
class Solution {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (nums == null || length < 2) {
            return null;
        }

        // 先排成升序
        int[] tempNums = Arrays.copyOf(nums, length);
        Arrays.sort(nums);
        // 首尾相加判断大小
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                break;
            }
        }
        int[] result = new int[2];
        // 现在得到了排序之后的下标，需要返回的是排序之前的下标
        // 因为数组中存在相同值的数字，再获取原来的下标就很麻烦，增加复杂度
        // 如果需要得到的是两个数字，这样就可以了
        return result;
    }

    /**
     * 另一种思路
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        // 时间复杂度O(n), 空间复杂度O()
        int length = nums.length;
        if (nums == null || length < 2) {
            return null;
        }
        // 利用hashmap做映射
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            // 先判断是否已经有满足条件的了，如果有可以直接返回
            Integer integer = hashMap.get(target - nums[i]);
            if (integer != null) {
                if (integer != i) {
                    // 不能是自己
                    result[0] = i;
                    result[1] = integer;
                    return result;
                }
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }

    public int[] twoSum3(int[] nums, int target) {
        // 由于范围有限
        // 2 <= nums.length <= 103 
        // -109 <= nums[i] <= 109 
        // -109 <= target <= 109 
        // 可以先计数排序,然后从数组两头往中间找
        int min = 109;
        int max = -109;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        int[] countSort = new int[max - min + 1];
        for (int num : nums) {
            countSort[num - min]++;
        }
        int index = 0;
        for (int i = 0; i < countSort.length; i++) {
            for (int j = 0; j < i; j++) {
                nums[index] = i + min;
                index++;
            }
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum < target) {
                low++;
            } else if (sum > target) {
                high--;
            } else {
                break;
            }
        }
        if (low < high) {
            // 现在得到了排序之后的下标，需要返回的是排序之前的下标
            // 因为数组中存在相同值的数字，再获取原来的下标就很麻烦，增加复杂度
            // 如果需要得到的是两个数字，这样就可以了
            return new int[]{low, high};
        } else {
            return null;
        }
    }

    /**
     * 测试入口
     *
     * @return
     */
    public static void testDoor() {
        Solution solution = new Solution();
        int[] ints = solution.twoSum3(new int[]{2, 5, 5, 15}, 10);
        System.out.println(JSON.toJSON(ints));

    }

    public static void main(String[] args) {
        testDoor();
    }
}
