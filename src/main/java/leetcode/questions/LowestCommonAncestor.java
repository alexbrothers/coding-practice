package leetcode.questions;

import leetcode.common.TreeNode;

public class LowestCommonAncestor {

    class TreeInfo {
        boolean pFound;
        boolean qFound;
        TreeNode result;

        TreeInfo(boolean pFound, boolean qFound, TreeNode result) {
            this.pFound = pFound;
            this.qFound = qFound;
            this.result = result;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p, q).result;
    }

    public TreeInfo lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new TreeInfo(false, false, null);
        }
        TreeInfo left = lowestCommonAncestorHelper(root.left, p, q);
        if (left.result != null) {
            return left;
        }
        TreeInfo right = lowestCommonAncestorHelper(root.right, p, q);
        if (right.result != null) {
            return right;
        }
        boolean bothPFound = left.pFound || right.pFound || root == p;
        boolean bothQFound = left.qFound || right.qFound || root == q;
        return new TreeInfo(bothPFound, bothQFound, bothPFound && bothQFound ? root : null);
    }

}
