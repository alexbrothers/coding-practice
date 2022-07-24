package leetcode.linkedin;

import leetcode.common.TreeNode;

public class LowestCommonAncestorBinaryTree {

    class TreeInfo {
        boolean pFound;
        boolean qFound;
        TreeNode lowestAncestor;

        public TreeInfo(boolean pFound, boolean qFound, TreeNode lowestAncestor) {
            this.pFound = pFound;
            this.qFound = qFound;
            this.lowestAncestor = lowestAncestor;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p, q).lowestAncestor;
    }

    private TreeInfo lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new TreeInfo(false, false, null);
        }
        TreeInfo left = lowestCommonAncestorHelper(root.left, p, q);
        if (left.lowestAncestor != null) {
            return left;
        }
        TreeInfo right = lowestCommonAncestorHelper(root.right, p, q);
        if (right.lowestAncestor != null) {
            return right;
        }
        boolean pFound = left.pFound || right.pFound || root.val == p.val;
        boolean qFound = left.qFound || right.qFound || root.val == q.val;
        return new TreeInfo(pFound, qFound, pFound && qFound ? root : null);
    }



}
