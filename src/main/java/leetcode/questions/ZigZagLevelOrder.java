package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean left = true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = left ? deque.pollFirst() : deque.pollLast();
                level.add(node.val);
                if (left) {
                    if (node.left != null) {
                        deque.add(node.left);
                    }
                    if (node.right != null) {
                        deque.add(node.right);
                    }
                }
                else {
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                }
            }
            result.add(level);
            left = !left;
        }
        return result;
    }

}
