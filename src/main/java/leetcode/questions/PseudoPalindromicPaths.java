package leetcode.questions;

import leetcode.common.TreeNode;

public class PseudoPalindromicPaths {

    class PathsCount {
        int count = 0;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        PathsCount pathsCount = new PathsCount();
        pseudoPalindromicPathsHelper(root, new int[9], pathsCount);
        return pathsCount.count;
    }

    private void pseudoPalindromicPathsHelper(TreeNode node, int[] counts, PathsCount pathsCount) {
        counts[node.val - 1]++;
        if (isLeaf(node)) {
            if (isPalindrome(counts)) {
                pathsCount.count++;
            }
        }
        else {
            if (node.left != null) {
                pseudoPalindromicPathsHelper(node.left, counts, pathsCount);
            }
            if (node.right != null) {
                pseudoPalindromicPathsHelper(node.right, counts, pathsCount);
            }
        }
        counts[node.val - 1]--;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private boolean isPalindrome(int[] counts) {
        int oddCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
