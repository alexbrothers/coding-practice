package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {
        return pathSumHelper(root, targetSum, 0, new HashMap<>());
    }

    private int pathSumHelper(TreeNode root, int targetSum, long currentSum, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        currentSum += root.val;
        if (currentSum == targetSum) {
            count++;
        }
        count += map.getOrDefault(currentSum - targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        count += pathSumHelper(root.left, targetSum, currentSum, map);
        count += pathSumHelper(root.right, targetSum, currentSum, map);
        map.put(currentSum, map.get(currentSum) - 1);
        return count;
    }

}
