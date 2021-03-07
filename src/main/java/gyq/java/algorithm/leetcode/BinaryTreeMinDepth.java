package gyq.java.algorithm.leetcode;

import gyq.java.algorithm.TreeNode;

/**
 * 二叉树最小深度
 *
 * @see https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class BinaryTreeMinDepth {
    // TODO: 2021/3/7 直接递归存在重叠子问题,可增加备忘录解决,考虑动态规划实现
    public int minDepth(TreeNode root) {
        if (root.getLeft() == null && root.getRight() != null) {
            // 只有右子树
            return minDepth(root.getRight()) + 1;
        } else if (root.getLeft() != null && root.getRight() == null) {
            // 只有左子树
            return minDepth(root.getLeft()) + 1;
        } else if (root.getLeft() != null && root.getRight() != null) {
            // 左右子树都有
            return Math.min(minDepth(root.getLeft()), minDepth(root.getRight())) + 1;
        } else {
            // 没有子节点
            return 1;
        }
    }
}
