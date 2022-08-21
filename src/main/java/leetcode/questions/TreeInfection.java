package leetcode.questions;

import leetcode.common.TreeNode;

public class TreeInfection {

    class TreeInfo {
        int depth;
        boolean found;
        int foundDepth;
        int answer = 0;

        TreeInfo(int depth, boolean found, int foundDepth, int answer) {
            this.depth = depth;
            this.found = found;
            this.foundDepth = foundDepth;
            this.answer = answer;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        return amountOfTimeHelper(root, start).answer;
    }

    private TreeInfo amountOfTimeHelper(TreeNode root, int target) {
        if (root == null) {
            return new TreeInfo(0, false, 0, 0);
        }
        TreeInfo left = amountOfTimeHelper(root.left, target);
        TreeInfo right = amountOfTimeHelper(root.right, target);
        if (root.val == target) {
            return new TreeInfo(Math.max(left.depth, right.depth) + 1, true, 0, Math.max(left.depth, right.depth));
        }
        if (left.found) {
            return new TreeInfo(Math.max(left.depth, right.depth) + 1, true, left.foundDepth + 1, Math.max(left.answer, left.foundDepth + right.depth + 1));
        }
        else if (right.found) {
            return new TreeInfo(Math.max(left.depth, right.depth) + 1, true, right.foundDepth + 1, Math.max(right.answer, right.foundDepth + left.depth + 1));
        }
        else {
            return new TreeInfo(Math.max(left.depth, right.depth) + 1, false, 0, 0);
        }
    }

}
