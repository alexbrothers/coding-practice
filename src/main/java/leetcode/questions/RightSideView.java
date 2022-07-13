package leetcode.questions;

import dailybyte.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class LeveledNode {
        TreeNode node;
        int level;

        LeveledNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<LeveledNode> queue = new LinkedList<>();
        queue.add(new LeveledNode(root, 0));
        while (!queue.isEmpty()) {
            LeveledNode current = queue.poll();
            if (queue.isEmpty() || queue.peek().level > current.level) {
                result.add(current.node.val);
            }
            if (current.node.left != null) {
                queue.add(new LeveledNode(current.node.left, current.level + 1));
            }
            if (current.node.right != null) {
                queue.add(new LeveledNode(current.node.right, current.level + 1));
            }
        }
        return result;
    }



}
