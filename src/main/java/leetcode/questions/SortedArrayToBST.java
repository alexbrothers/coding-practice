package leetcode.questions;

import leetcode.common.TreeNode;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) / 2);
        TreeNode result = new TreeNode(nums[mid]);
        result.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        result.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        return result;
    }

}
