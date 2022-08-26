package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    class NodeWidth {
        TreeNode node;
        long level;

        NodeWidth(TreeNode node, long level) {
            this.node = node;
            this.level = level;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        Queue<NodeWidth> queue = new LinkedList<>();
        queue.add(new NodeWidth(root, 0));
        int maxWidth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            long minLevel = Long.MAX_VALUE;
            long maxLevel = Long.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                NodeWidth current = queue.poll();
                minLevel = Math.min(minLevel, current.level);
                maxLevel = Math.max(maxLevel, current.level);
                if (current.node.left != null) {
                    queue.add(new NodeWidth(current.node.left, current.level * 2));
                }
                if (current.node.right != null) {
                    queue.add(new NodeWidth(current.node.right, (current.level * 2) + 1));
                }
            }
            maxWidth = Math.max(maxWidth, (int) (maxLevel - minLevel + 1));
        }
        return maxWidth;
    }

}
