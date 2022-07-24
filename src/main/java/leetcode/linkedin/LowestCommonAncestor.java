package leetcode.linkedin;

import leetcode.common.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p.val, q.val);
    }

    private TreeNode lowestCommonAncestorHelper(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q || (root.val > p && root.val < q) || (root.val > q && root.val < p)) {
            return root;
        }
        if (root.val > p) {
            return lowestCommonAncestorHelper(root.left, p, q);
        }
        else {
            return lowestCommonAncestorHelper(root.right, p, q);
        }
    }

}
