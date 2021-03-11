package gyq.java.algorithm.leetcode.p111_minimum_depth_of_binary_tree;

import gyq.java.common_data_struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最小深度
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */

class Solution {

    /**
     * DFS解决方法
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            // 只有右子树
            return minDepth(root.right) + 1;
        } else if (root.left != null && root.right == null) {
            // 只有左子树
            return minDepth(root.left) + 1;
        } else if (root.left != null && root.right != null) {
            // 左右子树都有
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            // 没有子节点
            return 1;
        }
    }

    /**
     * 2021/3/11 BFS解决方法
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> current = new LinkedList<>();
        current.offer(root);
        int finalStep = 1;
        // 遍历这一层中所有的节点
        while (!current.isEmpty()) {
            // 得到当前的size,从队列中取出当前size个元素
            int size = current.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = current.poll();
                if (poll.left == null && poll.right == null) {
                    // 到达一个叶子节点,没有子树了, 已经找到最小深度
                    return finalStep;
                }
                // 下一层节点放到队列中
                if (poll.left != null) {
                    current.offer(poll.left);
                }
                if (poll.right != null) {
                    current.offer(poll.right);
                }
            }
            // 向下一层,步数+1
            finalStep++;
        }
        return finalStep;
    }
}

//runtime:8 ms
//memory:59 MB
