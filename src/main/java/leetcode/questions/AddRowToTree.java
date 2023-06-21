package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && depth > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth--;
        }
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode oldLeft = current.left;
            TreeNode oldRight = current.right;
            current.left = new TreeNode(val);
            current.left.left = oldLeft;
            current.right = new TreeNode(val);
            current.right.right = oldRight;
        }
        return root;
    }

}
