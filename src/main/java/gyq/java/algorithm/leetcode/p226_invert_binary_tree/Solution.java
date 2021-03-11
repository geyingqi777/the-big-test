package gyq.java.algorithm.leetcode.p226_invert_binary_tree;

import gyq.java.common_data_struct.TreeNode;

/**
 * 翻转二叉树
 *
 * @see https://leetcode-cn.com/problems/invert-binary-tree/submissions/
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invert(root.left);
        invert(root.right);
    }
}