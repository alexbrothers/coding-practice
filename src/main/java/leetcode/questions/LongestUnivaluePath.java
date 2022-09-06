package leetcode.questions;

import leetcode.common.TreeNode;

public class LongestUnivaluePath {

    class MaxWrapper {
        int max;
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        MaxWrapper maxWrapper = new MaxWrapper();
        longestUnivaluePathHelper(root, maxWrapper);
        return maxWrapper.max - 1;
    }

    private int longestUnivaluePathHelper(TreeNode node, MaxWrapper maxWrapper) {
        if (node == null) {
            return 0;
        }
        int left = longestUnivaluePathHelper(node.left, maxWrapper);
        int right = longestUnivaluePathHelper(node.right, maxWrapper);
        int current = 1;
        if (node.left != null && node.left.val == node.val) {
            current = Math.max(current, left + 1);
        }
        if (node.right != null && node.right.val == node.val) {
            current = Math.max(current, right + 1);
        }
        if (node.left != null && node.left.val == node.val && node.right != null && node.right.val == node.val) {
            maxWrapper.max = Math.max(maxWrapper.max, left + right + 1);
        }
        maxWrapper.max = Math.max(maxWrapper.max, current);
        return current;
    }

}
