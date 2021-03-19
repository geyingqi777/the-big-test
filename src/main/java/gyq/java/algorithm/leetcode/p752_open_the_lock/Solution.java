package gyq.java.algorithm.leetcode.p752_open_the_lock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 打开转盘锁
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/open-the-lock/
 */
class Solution {
    private Set<String> visited = new HashSet<>();
    int endIndex = 4;

    public int openLock(String[] deadends, String target) {
        // BFS遍历图
        // 初始数字为"0000"
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (visited.contains(poll)) {
                    // 已访问过了
                    continue;
                }
                if (deads.contains(poll)) {
                    // 在死亡列表中, 需要跳过
                    continue;
                }
                if (poll.equals(target)) {
                    // 找到目标
                    return step;
                }
                visited.add(poll);
                // 没找到就把当前节点的下一步放到队列中
                queue.offer(switchNumber(poll, 0, 1));
                queue.offer(switchNumber(poll, 0, -1));
                queue.offer(switchNumber(poll, 1, 1));
                queue.offer(switchNumber(poll, 1, -1));
                queue.offer(switchNumber(poll, 2, 1));
                queue.offer(switchNumber(poll, 2, -1));
                queue.offer(switchNumber(poll, 3, 1));
                queue.offer(switchNumber(poll, 3, -1));
            }
            step++;
        }
        return -1;
    }

    /**
     * 表示拨动密码的方法
     *
     * @param poll
     * @param index
     * @param addValue
     * @return
     */
    private String switchNumber(String poll, int index, int addValue) {
        int value = Integer.parseInt(String.valueOf(poll.charAt(index)));
        int afterAdd = (value + 10 + addValue) % 10;
        // // 0反向转一下是9,不是-1
        // afterAdd = afterAdd < 0 ? 9 : afterAdd;
        // // 超过10了,回到0
        // afterAdd = afterAdd > 9 ? 0 : afterAdd;
        if (index == 0) {
            String s = afterAdd + poll.substring(1, endIndex);
            return s;
        } else if (index == endIndex) {
            String s = poll.substring(0, 3) + afterAdd;
            return s;
        } else {
            String s = poll.substring(0, index) + afterAdd + poll.substring(index + 1, endIndex);
            return s;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] deads = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int openLock = solution.openLock(deads, target);
        System.out.println(openLock);
    }
}