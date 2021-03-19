package gyq.java.algorithm.leetcode.p509_fibonacci_number;

/**
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/fibonacci-number/
 */
class Solution {
    public int fib(int n) {
        // dp(n) = dp(n-1) + dp(n-2)
        // dp(0)=0
        // dp(1)=1
        int first = 0;
        if (n == 0) {
            return first;
        }
        int second = 1;
        if (n == 1) {
            return second;
        }
        int third = first + second;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}