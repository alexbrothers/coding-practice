package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    class TreeNodeLevel {
        TreeNode node;
        int level;

        TreeNodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minLevel = 0;
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeLevel(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeLevel treeNodeLevel = queue.poll();
            List<Integer> current = map.getOrDefault(treeNodeLevel.level, new ArrayList<>());
            current.add(treeNodeLevel.node.val);
            minLevel = Math.min(minLevel, treeNodeLevel.level);
            map.put(treeNodeLevel.level, current);
            if (treeNodeLevel.node.left != null) {
                queue.add(new TreeNodeLevel(treeNodeLevel.node.left, treeNodeLevel.level - 1));
            }
            if (treeNodeLevel.node.right != null) {
                queue.add(new TreeNodeLevel(treeNodeLevel.node.right, treeNodeLevel.level + 1));
            }
        }
        while (!map.isEmpty()) {
            result.add(map.remove(minLevel));
            minLevel++;
        }
        return result;
    }

}
