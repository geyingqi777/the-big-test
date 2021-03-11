package gyq.java.algorithm.leetcode.p70_climb_stairs;

/**
 * 爬楼梯
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/climbing-stairs
 */
class Solution {
    public int climbStairs(int n) {
        // 状态转移方程 f(n) = f(n - 1) + f(n - 2)
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        // 迭代而非递归
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 递归的方式
     * <p>
     * 假设一个楼梯有 N 阶台阶，人每次最多可以跨 M 阶，求总共的爬楼梯方案数。
     * <p>
     * 例如楼梯总共有3个台阶，人每次最多跨2个台阶， 也就是说人每次可以走1个，也可以走2个，
     * <p>
     * 但最多不会超过2个， 那么楼梯总共有这么几种走法
     *
     * @param ladder
     * @param maxJump
     * @return
     */
    private static int calculateCount(int ladder, int maxJump) {
        int jump = 0;
        if (ladder == 0) {
            return 1;
        }
        if (ladder >= maxJump) {
            // 剩下的楼梯大于每一步的最大级数
            for (int i = 1; i <= maxJump; i++) {
                jump += calculateCount(ladder - i, maxJump);
            }
        } else {
            // 剩下的楼梯不足最大可跳跃数
            jump = calculateCount(ladder, ladder);
        }
        return jump;
    }

    /**
     * 当calculateCount方法中,maxJump等于2的时候的特殊情况
     *
     * @param n
     * @return
     */
    private static long calculateCount2(int n) {
        if (n == 1) {
            // 一级台阶只有1种方法
            return 1;
        } else if (n == 2) {
            // 二级台阶2种，其实可以省略的 不过为了初学者能够看清楚 我这里写出来
            return 2;
        }
        // 这是递归的方法
        return calculateCount2(n - 1) + calculateCount2(n - 2);
    }
}

//runtime:0 ms
//memory:35.2 MB
