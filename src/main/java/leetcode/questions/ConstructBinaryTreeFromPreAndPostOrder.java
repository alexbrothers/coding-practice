package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreAndPostOrder {

    class PreorderIndex {
        int index = 0;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || postorder == null || preorder.length != postorder.length) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> postorderIndexes = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postorderIndexes.put(postorder[i], i);
        }
        return construct(preorder, new PreorderIndex(), postorder.length - 1, postorderIndexes);
    }

    private TreeNode construct(int[] preorder, PreorderIndex preorderIndex, int prevPostorderIndex, Map<Integer, Integer> postorderIndexes) {
        if (preorderIndex.index >= preorder.length) {
            return null;
        }
        int value = preorder[preorderIndex.index];
        int postOrderIndex = postorderIndexes.get(value);
        if (postOrderIndex > prevPostorderIndex) {
            return null;
        }
        preorderIndex.index++;
        TreeNode left = construct(preorder, preorderIndex, postOrderIndex, postorderIndexes);
        TreeNode right = construct(preorder, preorderIndex, postOrderIndex, postorderIndexes);
        return new TreeNode(value, left, right);
    }

}
