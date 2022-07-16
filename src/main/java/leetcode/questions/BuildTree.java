package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class IndexWrapper {
        int index = 0;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> inOrderIndexes = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexes.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, new IndexWrapper(), 0, preorder.length - 1, inOrderIndexes);
    }

    private TreeNode buildTreeHelper(int[] preorder, IndexWrapper preorderIndex, int minIndex, int maxIndex, Map<Integer, Integer> inOrderIndexes) {
        if (preorderIndex.index >= preorder.length || minIndex > maxIndex) {
            return null;
        }
        int value = preorder[preorderIndex.index];
        int inOrderIndex = inOrderIndexes.get(value);
        TreeNode node = new TreeNode(value);
        preorderIndex.index++;
        node.left = buildTreeHelper(preorder, preorderIndex, minIndex, inOrderIndex - 1, inOrderIndexes);
        node.right = buildTreeHelper(preorder, preorderIndex, inOrderIndex + 1, maxIndex, inOrderIndexes);
        return node;
    }

}
