package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSumHelper(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSumHelper(TreeNode node, int sum, List<Integer> current, List<List<Integer>> result) {
        current.add(node.val);
        int newSum = sum - node.val;
        if (isLeaf(node)) {
            if (newSum == 0) {
                result.add(new ArrayList<>(current));
            }
        }
        else {
            if (node.left != null) {
                pathSumHelper(node.left, newSum, current, result);
            }
            if (node.right != null) {
                pathSumHelper(node.right, newSum, current, result);
            }
        }
        current.remove(current.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}
