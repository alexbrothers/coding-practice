package leetcode.google;

import leetcode.common.TreeNode;

public class DiameterOfBinaryTree {

    class SolutionWrapper {
        int max = 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        SolutionWrapper solutionWrapper = new SolutionWrapper();
        diameterOfBinaryTreeHelper(root, solutionWrapper);
        return solutionWrapper.max;
    }

    private int diameterOfBinaryTreeHelper(TreeNode root, SolutionWrapper solutionWrapper) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTreeHelper(root.left, solutionWrapper);
        int right = diameterOfBinaryTreeHelper(root.right, solutionWrapper);
        solutionWrapper.max = Math.max(solutionWrapper.max, left + right);
        return Math.max(left, right) + 1;
    }

}
