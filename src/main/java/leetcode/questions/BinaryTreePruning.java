package leetcode.questions;

import leetcode.common.TreeNode;

public class BinaryTreePruning {

    class PruneHelper {
        TreeNode node;
        boolean hasOne;

        PruneHelper(TreeNode node, boolean hasOne) {
            this.node = node;
            this.hasOne = hasOne;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        PruneHelper result = pruneTreeHelper(root);
        if (!result.hasOne) {
            return null;
        }
        return result.node;
    }

    private PruneHelper pruneTreeHelper(TreeNode node) {
        if (node == null) {
            return new PruneHelper(null, false);
        }
        PruneHelper left = pruneTreeHelper(node.left);
        PruneHelper right = pruneTreeHelper(node.right);
        if (!left.hasOne) {
            node.left = null;
        }
        if (!right.hasOne) {
            node.right = null;
        }
        boolean hasOne = false;
        if (node.val == 1) {
            hasOne = true;
        }
        return new PruneHelper(node, hasOne || left.hasOne || right.hasOne);
    }

}
