package leetcode.questions;

import leetcode.common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

    public int longestConsecutive(TreeNode root) {
        return longestSequence(root, 1, null);
    }

    private int longestSequence(TreeNode node, int count, Integer previousValue) {
        if (node == null) {
            return 0;
        }
        if (previousValue != null && previousValue == node.val - 1) {
            count++;
        }
        else {
            count = 1;
        }
        return Math.max(count, Math.max(longestSequence(node.left, count, node.val), longestSequence(node.right, count, node.val)));
    }

}
