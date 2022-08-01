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
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(new TreeNode(nums[i], i, i, null, null));
        }
        while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                TreeNode node1 = queue.poll();
                if (queue.isEmpty()) {
                    if (node1.left == 0 && node1.right == nums.length - 1) {
                        node = node1;
                    }
                    else {
                        node = new TreeNode(node1.sum, node1.left, node1.right, null, node1);
                    }
                }
                else {
                    TreeNode node2 = queue.poll();
                    node = new TreeNode(node1.sum + node2.sum, node1.left, node2.right, node1, node2);
                }
                if (node.left == 0 && node.right == nums.length - 1) {
                    root = node;
                    break;
                }
                queue.add(node);
            }
        }
    }

    public void update(int index, int val) {
        updateHelper(index, val, root);
    }

    private int updateHelper(int index, int val, TreeNode node) {
        if (node.left == index && node.right == index) {
            int diff = node.sum - val;
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
        if (mid >= node.left) {
            sum += sumRangeHelper(left, right, node.leftNode);
        }
        if (mid < node.right) {
            sum += sumRangeHelper(left, right, node.rightNode);
        }
        return sum;
    }

}
