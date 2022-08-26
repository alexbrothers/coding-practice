package practice.questions;

public class SubtreesWithinRange {

    static class SubTreeInfo {
        int min;
        int max;
        int count;

        SubTreeInfo(int min, int max, int count) {
            this.min = min;
            this.max = max;
            this.count = count;
        }
    }

    public static int subtreesWithinRange(BST tree, int[] targetRange) {
        if (targetRange == null || targetRange.length != 2) {
            throw new IllegalArgumentException();
        }
        return subtreesWithinRangeHelper(tree, targetRange[0], targetRange[1]).count;
    }

    private static SubTreeInfo subtreesWithinRangeHelper(BST node, int targetMin, int targetMax) {
        if (node == null) {
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        SubTreeInfo left = subtreesWithinRangeHelper(node.left, targetMin, targetMax);
        SubTreeInfo right = subtreesWithinRangeHelper(node.right, targetMin, targetMax);
        int resultMin = Math.min(left.min, node.value);
        int resultMax = Math.max(right.max, node.value);
        int add = isInRange(resultMin, resultMax, targetMin, targetMax) ? 1 : 0;
        return new SubTreeInfo(resultMin, resultMax, left.count + right.count + add);
    }

    private static boolean isInRange(int min, int max, int targetMin, int targetMax) {
        return min >= targetMin && max <= targetMax;
    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}
