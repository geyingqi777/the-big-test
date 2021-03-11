package gyq.java.algorithm.leetcode.p111_minimum_depth_of_binary_tree;

import gyq.java.common_data_struct.TreeNode;

/**
 * 二叉树最小深度
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */

class Solution {
    public int minDepth(TreeNode root) {
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
}

//runtime:8 ms
//memory:59 MB
