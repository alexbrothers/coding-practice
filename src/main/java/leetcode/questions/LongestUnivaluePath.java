<<<<<<< HEAD
package leetcode.questions;

import leetcode.common.TreeNode;

public class LongestUnivaluePath {

    class MaxWrapper {
        int maxPath = 0;
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        MaxWrapper maxWrapper = new MaxWrapper();
        longestUnivaluePathHelper(root, maxWrapper);
        return maxWrapper.maxPath - 1;
    }

    private int longestUnivaluePathHelper(TreeNode root, MaxWrapper maxWrapper) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePathHelper(root.left, maxWrapper);
        int right = longestUnivaluePathHelper(root.right, maxWrapper);
        boolean leftMatching = root.left != null && root.left.val == root.val;
        boolean rightMatching = root.right != null && root.right.val == root.val;
        int longestBranch;
        if (leftMatching && rightMatching) {
            longestBranch = Math.max(left, right) + 1;
            maxWrapper.maxPath = Math.max(maxWrapper.maxPath, left + right + 1);
        }
        else if (leftMatching) {
            longestBranch = left + 1;
        }
        else if (rightMatching) {
            longestBranch = right + 1;
        }
        else {
            longestBranch = 1;
        }
        maxWrapper.maxPath = Math.max(maxWrapper.maxPath, longestBranch);
        return longestBranch;
    }

}
=======
package leetcode.questions;

import leetcode.common.TreeNode;

>>>>>>> cc62efc58574367f2a1ea564479be759d2331084
