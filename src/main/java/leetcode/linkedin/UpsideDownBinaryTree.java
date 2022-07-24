package leetcode.linkedin;

import leetcode.common.TreeNode;

public class UpsideDownBinaryTree {

    class RootWrapper {
        TreeNode root = null;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        RootWrapper rootWrapper = new RootWrapper();
        upsideDownBinaryTree(root, null, rootWrapper);
        return rootWrapper.root;
    }

    private void upsideDownBinaryTree(TreeNode node, TreeNode parent, RootWrapper rootWrapper) {
        if (node == null) {
            return;
        }
        TreeNode oldRight = node.right;
        upsideDownBinaryTree(node.left, node, rootWrapper);
        if (parent != null && parent.left == node) {
            node.right = parent;
            node.left = parent.right;
        }
        else if (parent == null) {
            node.left = null;
            node.right = null;
        }
        if (rootWrapper.root == null) {
            rootWrapper.root = node;
        }
        upsideDownBinaryTree(oldRight, node, rootWrapper);
    }

}
