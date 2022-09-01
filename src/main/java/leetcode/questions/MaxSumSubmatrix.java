package leetcode.questions;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumSubmatrix {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[matrix[0].length];
        for (int startRow = 0; startRow < matrix.length; startRow++) {
            Arrays.fill(dp, 0);
            for (int i = startRow; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dp[j] += matrix[i][j];
                }
                max = Math.max(max, getMaxLessThanK(dp, k));
            }
        }

        return max;
    }

    private int getMaxLessThanK(int[] dp, int k) {
        int max = Integer.MIN_VALUE;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
            Integer best = treeSet.ceiling(sum - k);
            if (best != null) {
                max = Math.max(max, sum - best);
            }
            treeSet.add(sum);
        }
        return max;
    }

}
