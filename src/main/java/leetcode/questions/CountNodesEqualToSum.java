package leetcode.questions;

import leetcode.common.TreeNode;

public class CountNodesEqualToSum {

    class CountNodesHelper {
        int count;
        int sum;

        CountNodesHelper(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    public int equalToDescendants(TreeNode root) {
        return count(root).count;
    }

    private CountNodesHelper count(TreeNode node) {
        if (node == null) {
            return new CountNodesHelper(0, 0);
        }
        CountNodesHelper left = count(node.left);
        CountNodesHelper right = count(node.right);
        int sum = left.sum + right.sum;
        int count = left.count + right.count;
        if (node.val == sum) {
            count++;
        }
        return new CountNodesHelper(count, sum + node.val);
    }

}
