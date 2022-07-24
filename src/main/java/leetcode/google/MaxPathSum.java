package leetcode.google;

import leetcode.common.TreeNode;

public class MaxPathSum {

    class SumWrapper {
        int max = Integer.MIN_VALUE;
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        SumWrapper sumWrapper = new SumWrapper();
        maxPathSumHelper(root, sumWrapper);
        return sumWrapper.max;
    }

    private int maxPathSumHelper(TreeNode node, SumWrapper sumWrapper) {
        if (node == null) {
            return 0;
        }
        int leftSum = maxPathSumHelper(node.left, sumWrapper);
        int rightSum = maxPathSumHelper(node.right, sumWrapper);
        int maxBranch = Math.max(node.val, Math.max(leftSum + node.val, rightSum + node.val));
        sumWrapper.max = Math.max(sumWrapper.max, Math.max(maxBranch, leftSum + rightSum + node.val));
        return maxBranch;
    }

}
