package leetcode.questions;

import java.util.LinkedList;
import java.util.Queue;

public class NumArray {

    class TreeNode {
        int sum;
        int left;
        int right;
        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(int sum, int left, int right, TreeNode leftNode, TreeNode rightNode) {
            this.sum = sum;
            this.left = left;
            this.right = right;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    TreeNode root;

    public NumArray(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        root = split(0, nums.length - 1, 0, nums.length - 1, sum, nums);
    }

    private TreeNode split(int left, int right, int oldLeft, int oldRight, int oldSum, int[] nums) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left], left, right, null, null);
        }
        if (left > oldLeft) {
            for (int i = oldLeft; i < left; i++) {
                oldSum -= nums[i];
            }
        }
        if (right < oldRight) {
            for (int i = oldRight; i > right; i--) {
                oldSum -= nums[i];
            }
        }
        TreeNode node = new TreeNode(oldSum, left, right, null, null);
        int mid = node.left + ((node.right - node.left) / 2);
        node.leftNode = split(left, mid, left, right, oldSum, nums);
        node.rightNode = split(mid + 1, right, left, right, oldSum, nums);
        return node;
    }

    public void update(int index, int val) {
        updateHelper(index, val, root);
    }

    private int updateHelper(int index, int val, TreeNode node) {
        if (node.left == index && node.right == index) {
            int diff = val - node.sum;
            node.sum = val;
            return diff;
        }
        int mid = node.left + ((node.right - node.left) / 2);
        int diff;
        if (index <= mid) {
            diff = updateHelper(index, val, node.leftNode);
        }
        else {
            diff = updateHelper(index, val, node.rightNode);
        }
        node.sum += diff;
        return diff;
    }

    public int sumRange(int left, int right) {
        return sumRangeHelper(left, right, root);
    }

    private int sumRangeHelper(int left, int right, TreeNode node) {
        if (node.left >= left && node.right <= right) {
            return node.sum;
        }
        int mid = node.left + ((node.right - node.left) / 2);
        int sum = 0;
        if (mid >= left) {
            sum += sumRangeHelper(left, right, node.leftNode);
        }
        if (mid < right) {
            sum += sumRangeHelper(left, right, node.rightNode);
        }
        return sum;
    }

}
