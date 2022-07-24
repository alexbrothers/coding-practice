package leetcode.linkedin;

import leetcode.common.TreeNode;

public class SecondMinimum {

    public int findSecondMinimumValue(TreeNode root) {
        Integer result = findSecondMinimumHelper(root, root.val);
        return result == null ? -1 : result;
    }

    private Integer findSecondMinimumHelper(TreeNode node, int minimum) {
        if (node == null) {
            return null;
        }
        if (node.val > minimum) {
            return node.val;
        }
        Integer minLeft = findSecondMinimumHelper(node.left, minimum);
        Integer minRight = findSecondMinimumHelper(node.right, minimum);
        if (minLeft == null && minRight == null) {
            return null;
        }
        if (minLeft == null) {
            return minRight;
        }
        if (minRight == null) {
            return minLeft;
        }
        return Math.min(minLeft, minRight);
    }

}
