package leetcode.questions;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        return generateHelper(1, n);
    }

    private List<TreeNode> generateHelper(int minIndex, int maxIndex) {
        List<TreeNode> options = new ArrayList<>();
        if (minIndex > maxIndex) {
            options.add(null);
            return options;
        }
        for (int i = minIndex; i <= maxIndex; i++) {
            List<TreeNode> leftOptions = generateHelper(minIndex, i - 1);
            List<TreeNode> rightOptions = generateHelper(i + 1, maxIndex);
            TreeNode root = new TreeNode(i);
            options.addAll(generateOptions(leftOptions, rightOptions, root));
        }
        return options;
    }

    private List<TreeNode> generateOptions(List<TreeNode> left, List<TreeNode> right, TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        for (int i = 0; i < left.size(); i++) {
            TreeNode leftOption = left.get(i);
            for (int j = 0; j < right.size(); j++) {
                TreeNode rightOption = right.get(j);
                root.left = leftOption;
                root.right = rightOption;
                result.add(new TreeNode(root.val, root.left, root.right));
            }
        }
        return result;
    }

}
