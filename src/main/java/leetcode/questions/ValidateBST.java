package leetcode.questions;

import leetcode.common.TreeNode;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, null, null);
    }

    private boolean isValidBst(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        return (min == null || node.val > min) && (max == null || node.val < max) && isValidBst(node.left, min, node.val) && isValidBst(node.right, node.val, max);
    }

}
