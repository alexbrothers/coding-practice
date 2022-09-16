package leetcode.questions;

import leetcode.common.TreeNode;

public class BinaryTreeString {

    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root != null) {
            treeToString(root, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void treeToString(TreeNode root, StringBuilder stringBuilder) {
        stringBuilder.append(root.val);
        if (root.left != null && root.right != null) {
            stringBuilder.append('(');
            treeToString(root.left, stringBuilder);
            stringBuilder.append(')');
            stringBuilder.append('(');
            treeToString(root.right, stringBuilder);
            stringBuilder.append(')');
        }
        else if (root.left != null) {
            stringBuilder.append('(');
            treeToString(root.left, stringBuilder);
            stringBuilder.append(')');
        }
        else if (root.right != null) {
            stringBuilder.append("()");
            stringBuilder.append('(');
            treeToString(root.right, stringBuilder);
            stringBuilder.append(')');
        }
    }

}
