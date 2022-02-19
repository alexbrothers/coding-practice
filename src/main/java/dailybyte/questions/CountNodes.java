package dailybyte.questions;

import dailybyte.common.TreeNode;

public class CountNodes {

    /**
     * Given a binary tree, count the total number of nodes it contains.
     *
     * Ex: Given the following binary tree...
     *
     *          1
     *         / \
     *        2   3, return 3.
     */
    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

}
