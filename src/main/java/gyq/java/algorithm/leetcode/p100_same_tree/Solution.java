package gyq.java.algorithm.leetcode.p100_same_tree;

import gyq.java.common_data_struct.TreeNode;

/**
 * 相同的树
 *
 * @see https://leetcode-cn.com/problems/same-tree/
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 先序, 先对当前节点做判断
        // 递归退出条件
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        // 左子树做判断
        boolean sameNode = isSameTree(p.left, q.left);
        if (sameNode == false) {
            return false;
        }
        // 右子树做判断
        boolean sameNode1 = isSameTree(p.right, q.right);
        if (sameNode1 == false) {
            return false;
        }
        return true;
    }
}