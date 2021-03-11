package gyq.java.algorithm.leetcode.p46_permutations;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 全排列
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/permutations/
 */
class Solution {
    private LinkedList<Integer> tracked = new LinkedList<>();
    private List<List<Integer>> result = new LinkedList<>();
    // 当入参没有重复数字时,可以用set来判断是否访问过了,否则就用tracked自己来判断了
    private Set<Integer> visited = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        if (nums.length == tracked.size()) {
            result.add(new LinkedList<>(tracked));
            // 遍历完一条路径,递归退出条件
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (visited.contains(num)) {
                // 已访问过的排除
                continue;
            }
            // 做选择
            tracked.addLast(num);
            visited.add(num);
            // 进入下层决策树
            backtrack(nums);
            // 退出下层决策树,取消选择
            tracked.removeLast();
            visited.remove(num);
        }
    }
}