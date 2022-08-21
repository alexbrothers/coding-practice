package leetcode.questions;

import leetcode.common.TreeNode;

public class RecoverTree {

    class TreeInfo {
        public TreeNode a;
        public TreeNode b;
        public boolean first;
        public boolean finished;
        public TreeNode previous;

        TreeInfo(TreeNode a, TreeNode b, boolean first, boolean finished, TreeNode previous) {
            this.a = a;
            this.b = b;
            this.first = first;
            this.finished = finished;
            this.previous = previous;
        }
    }

    public void recoverTree(TreeNode root) {
        TreeInfo treeInfo = new TreeInfo(null, null, false, false, null);
        recoverTree(root, treeInfo);
        swap(treeInfo.a, treeInfo.b);
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    private void recoverTree(TreeNode root, TreeInfo treeInfo) {
        if (root == null || treeInfo.finished) {
            return;
        }
        recoverTree(root.left, treeInfo);
        if (treeInfo.finished) {
            return;
        }
        if (treeInfo.previous != null && treeInfo.previous.val > root.val) {
            if (treeInfo.first) {
                treeInfo.finished = true;
                treeInfo.b = root;
                return;
            }
            else {
                treeInfo.first = true;
                treeInfo.a = treeInfo.previous;
                treeInfo.b = root;
            }
        }
        treeInfo.previous = root;
        recoverTree(root.right, treeInfo);
    }

}
