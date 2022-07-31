package leetcode.questions;

import leetcode.common.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    private TreeNode flatten(TreeNode node, TreeNode prev) {
        if (node == null) {
            return null;
        }
        if (prev != null) {
            prev.right = node;
        }
        TreeNode oldRight = node.right;
        TreeNode leftLast = flatten(node.left, node);
        TreeNode rightLast = flatten(oldRight, leftLast == null ? node : leftLast);
        node.left = null;
        if (rightLast != null) {
            return rightLast;
        }
        if (leftLast != null) {
            return leftLast;
        }
        return node;
    }

}
