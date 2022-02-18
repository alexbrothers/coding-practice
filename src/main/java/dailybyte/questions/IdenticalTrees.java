package dailybyte.questions;

import dailybyte.common.TreeNode;

public class IdenticalTrees {

    /**
     * Given two binary trees, return whether or not the two trees are identical.
     * Note: identical meaning they exhibit the same structure and the same values at each node.
     * Ex: Given the following trees...
     *
     *         2
     *        / \
     *       1   3
     *     2
     *    / \
     *   1   3
     *
     * return true.
     *
     * Ex: Given the following trees...
     *
     *         1
     *          \
     *           9
     *            \
     *            18
     *     1
     *    /
     *   9
     *    \
     *     18
     *
     * return false.
     *
     * Ex: Given the following trees...
     *
     *         2
     *        / \
     *       3   1
     *     2
     *    / \
     *   1   3
     *
     * return false.
     */
    public boolean identicalTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.value != node2.value) {
            return false;
        }
        return identicalTrees(node1.left, node2.left) && identicalTrees(node1.right, node2.right);
    }

}
