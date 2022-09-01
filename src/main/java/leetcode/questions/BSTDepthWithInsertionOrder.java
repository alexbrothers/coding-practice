package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.Map;
import java.util.TreeMap;

public class BSTDepthWithInsertionOrder {

    public int maxDepthBST(int[] order) {
        if (order == null || order.length == 0) {
            throw new IllegalArgumentException();
        }
        int depth = 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(order[0], 1);
        for (int i = 1; i < order.length; i++) {
            int value = order[i];
            Map.Entry<Integer, Integer> left = treeMap.ceilingEntry(value);
            Map.Entry<Integer, Integer> right = treeMap.floorEntry(value);
            int nextDepth = 0;
            if (left != null && right != null) {
                nextDepth = 1 + Math.max(left.getValue(), right.getValue());
            }
            else if (left == null) {
                nextDepth = 1 + right.getValue();
            }
            else {
                nextDepth = 1 + left.getValue();
            }
            treeMap.put(value, nextDepth);
            depth = Math.max(depth, nextDepth);
        }
        return depth;
    }

}
