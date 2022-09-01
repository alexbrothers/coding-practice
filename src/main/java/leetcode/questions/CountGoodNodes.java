package leetcode.questions;

import leetcode.common.TreeNode;

public class CountGoodNodes {

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int current = 0;
        if (node.val >= max) {
            current++;
        }
        int newMax = Math.max(max, node.val);
        return current + countGoodNodes(node.left, newMax) + countGoodNodes(node.right, newMax);
    }

}
