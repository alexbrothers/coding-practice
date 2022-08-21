package leetcode.questions;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        return numTrees(1, n, new int[n - 1]);
    }

    private int numTrees(int min, int max, int[] memo) {
        if (min >= max) {
            return 1;
        }
        int numNodes = max - min;
        if (memo[numNodes - 1] != 0) {
            return memo[numNodes - 1];
        }
        int count = 0;
        for (int i = min; i <= max; i++) {
            int leftCount = numTrees(min, i - 1, memo);
            int rightCount = numTrees(i + 1, max, memo);
            count += (leftCount * rightCount);
        }
        memo[numNodes - 1] = count;
        return count;
    }

}
