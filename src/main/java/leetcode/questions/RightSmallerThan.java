package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        List<Integer> result = new ArrayList<>();
        BSTNode root = null;
        for (int i = array.size() - 1; i >= 0; i--) {
            root = insert(array.get(i), root, result, 0);
        }
        return result;
    }

    private static BSTNode insert(int val, BSTNode current, List<Integer> result, int count) {
        if (current == null) {
            result.add(0, count);
            return new BSTNode(val, count);
        }
        if (val <= current.val) {
            current.smallerThanCount++;
            current.left = insert(val, current.left, result, count);
        }
        else {
            current.right = insert(val, current.right, result, count + 1 + current.smallerThanCount);
        }
        return current;
    }

    static class BSTNode {
        int val;
        BSTNode left;
        BSTNode right;
        int smallerThanCount;

        public BSTNode(int val, int smallerThanCount) {
            this.val = val;
        }
    }

}
