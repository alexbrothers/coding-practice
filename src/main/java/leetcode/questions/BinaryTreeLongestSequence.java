package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLongestSequence {

    class MaxWrapper {
        int max = 0;
    }

    class TreeSequenceInfo {
        int increasingBranchSize;
        int decreasingBranchSize;

        public TreeSequenceInfo(int increasingBranchSize, int decreasingBranchSize) {
            this.increasingBranchSize = increasingBranchSize;
            this.decreasingBranchSize = decreasingBranchSize;
        }
    }

    public int longestConsecutive(TreeNode root) {
        MaxWrapper maxWrapper = new MaxWrapper();
        longestConsecutiveHelper(root, maxWrapper);
        return maxWrapper.max;
    }

    private TreeSequenceInfo longestConsecutiveHelper(TreeNode node, MaxWrapper maxWrapper) {
        if (node == null) {
            return null;
        }
        TreeSequenceInfo left = longestConsecutiveHelper(node.left, maxWrapper);
        TreeSequenceInfo right = longestConsecutiveHelper(node.right, maxWrapper);
        int increasing = 1;
        int decreasing = 1;
        if (node.left != null) {
            if (node.left.val + 1 == node.val) {
                increasing = Math.max(increasing, left.increasingBranchSize + 1);
            }
            else if (node.left.val - 1 == node.val) {
                decreasing = Math.max(decreasing, left.decreasingBranchSize + 1);
            }
        }
        if (node.right != null) {
            if (node.right.val + 1 == node.val) {
                increasing = Math.max(increasing, right.increasingBranchSize + 1);
            }
            else if (node.right.val - 1 == node.val) {
                decreasing = Math.max(decreasing, right.decreasingBranchSize + 1);
            }
        }
        maxWrapper.max = Math.max(maxWrapper.max, increasing + decreasing - 1);
        return new TreeSequenceInfo(increasing, decreasing);
    }

}
