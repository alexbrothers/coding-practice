package leetcode.linkedin;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeaves {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLeavesHelper(root, result);
        return result;
    }

    private int findLeavesHelper(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }
        int heightFromLeave = Math.max(findLeavesHelper(root.left, result), findLeavesHelper(root.right, result));
        if (result.size() <= heightFromLeave) {
            result.add(new ArrayList<>());
        }
        List<Integer> leaves = result.get(heightFromLeave);
        leaves.add(root.val);
        return heightFromLeave + 1;
    }

}
