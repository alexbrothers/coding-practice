package leetcode.questions;

import leetcode.common.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, 0, targetSum);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private boolean hasPathSumHelper(TreeNode node, int sum, int targetSum) {
        int newSum = sum + node.val;
        if (isLeaf(node)) {
            return newSum == targetSum;
        }
        if (node.left != null && hasPathSumHelper(node.left, newSum, targetSum)) {
            return true;
        }
        if (node.right != null && hasPathSumHelper(node.right, newSum, targetSum)) {
            return true;
        }
        return false;
    }

}
