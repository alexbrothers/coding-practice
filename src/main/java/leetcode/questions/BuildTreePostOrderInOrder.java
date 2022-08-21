package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePostOrderInOrder {

    class IndexWrapper {
        int index;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        IndexWrapper indexWrapper = new IndexWrapper();
        indexWrapper.index = inorder.length - 1;
        return buildTree(postorder, indexWrapper, map, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, IndexWrapper indexWrapper, Map<Integer, Integer> map, int minIndex, int maxIndex) {
        if (indexWrapper.index < 0 || minIndex > maxIndex) {
            return null;
        }
        int num = postorder[indexWrapper.index];
        int index = map.get(num);
        if (index < minIndex || index > maxIndex) {
            return null;
        }
        indexWrapper.index--;
        TreeNode node = new TreeNode(num);
        node.right = buildTree(postorder, indexWrapper, map, index + 1, maxIndex);
        node.left = buildTree(postorder, indexWrapper, map, minIndex, index - 1);
        return node;
    }

}
