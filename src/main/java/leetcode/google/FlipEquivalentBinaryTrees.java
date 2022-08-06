package leetcode.google;

import leetcode.common.TreeNode;

public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        if (noFlip) {
            return true;
        }
        TreeNode temp = root2.left;
        root2.left = root2.right;
        root2.right = temp;
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }

}
