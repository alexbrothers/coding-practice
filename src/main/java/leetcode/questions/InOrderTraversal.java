package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, result);
        result.add(node.val);
        inOrderTraversal(node.right, result);
    }

}
