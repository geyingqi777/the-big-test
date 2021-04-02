package gyq.java.algorithm.convert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 现在有一个没有重复元素的整数集合S，求S的所有子集
 * 注意：
 * 你给出的子集中的元素必须按升序排列
 * 给出的解集中不能出现重复的元素
 * 例如：
 * 如果S=[1,2,3], 给出的解集应为：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] S = new int[]{1, 2, 3};
        ArrayList<ArrayList<Integer>> result = solution.subsets(S);
        System.out.println(result);
    }

    // 最终的结果集
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Set<Integer> resovled = new HashSet<>();
        LinkedList<Integer> oneSubSet = new LinkedList<>();
        collect(S, resovled, oneSubSet);
        return result;
    }


    private void collect(int[] source, Set<Integer> resolved, LinkedList<Integer> oneSubSet) {

        // 找到未出现过的,加入到结果中
        int sizeBefore = oneSubSet.size();
        int lastInt = 0;
        if (sizeBefore > 0) {
            // 长度大于0时,取出最后一个
            lastInt = oneSubSet.getLast();
        }
        for (int i = 0; i < source.length; i++) {
            if (source[i] <= lastInt && sizeBefore > 0) {
                // 不大于上个元素,跳过
                continue;
            }
            // 找有没有大于上一个元素的
            oneSubSet.add(source[i]);
            resolved.add(source[i]);
            // 加入到结果集中
            result.add(new ArrayList(oneSubSet));
            // 递归下一层
            collect(source, resolved, oneSubSet);
            // 取消选择
            oneSubSet.removeLast();
            resolved.remove(source[i]);
        }

    }
}
