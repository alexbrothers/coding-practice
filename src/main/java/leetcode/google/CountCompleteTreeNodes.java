package leetcode.google;

import leetcode.common.TreeNode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int depth = countDepth(root);
        if (depth == 0) {
            return 0;
        }
        if (depth == 1) {
            return 1;
        }
        int left = 0;
        int right = (int) Math.pow(2, depth - 1) - 1;
        while (left <= right) {
            int candidate = left + ((right - left) / 2);
            if (exists(root, 0, (int) Math.pow(2, depth - 1) - 1, candidate, depth - 1)) {
                left = candidate + 1;
            }
            else {
                right = candidate - 1;
            }
        }
        return (int) (Math.pow(2, depth - 1) - 1) + left;
    }

    private boolean exists(TreeNode node, int left, int right, int index, int depth) {
        for (int i = 0; i < depth; i++) {
            int pivot = left + ((right - left) / 2);
            if (index > pivot) {
                node = node.right;
                left = pivot + 1;
            }
            else {
                node = node.left;
                right = pivot - 1;
            }
        }
        return node != null;
    }

    private int countDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countDepth(node.left);
    }

}
