package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.*;

public class VerticalOrderTraversalBinaryTree {

    class TreeNodeLevel {
        TreeNode node;
        int col;

        TreeNodeLevel(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeLevel(root, 0));
        int minCol = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> tempMap = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNodeLevel current = queue.poll();
                minCol = Math.min(minCol, current.col);
                List<Integer> currentCol = tempMap.getOrDefault(current.col, new ArrayList<>());
                currentCol.add(current.node.val);
                if (current.node.left != null) {
                    queue.add(new TreeNodeLevel(current.node.left, current.col - 1));
                }
                if (current.node.right != null) {
                    queue.add(new TreeNodeLevel(current.node.right, current.col + 1));
                }
                tempMap.put(current.col, currentCol);
            }
            for (Map.Entry<Integer, List<Integer>> entry : tempMap.entrySet()) {
                int row = entry.getKey();
                List<Integer> nums = entry.getValue();
                Collections.sort(nums);
                List<Integer> old = map.getOrDefault(row, new ArrayList<>());
                old.addAll(nums);
                map.put(row, old);
            }
        }
        return convert(minCol, map);
    }

    private List<List<Integer>> convert(int minCol, Map<Integer, List<Integer>> map) {
        List<List<Integer>> result = new ArrayList<>();
        while (!map.isEmpty()) {
            result.add(map.get(minCol));
            map.remove(minCol);
            minCol++;
        }
        return result;
    }

}
