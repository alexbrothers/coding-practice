package leetcode.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubMatrixSums {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int[][] dp = createDpMatrix(matrix);
        int count = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int col = 1; col < dp[0].length; col++) {
                    int sum = dp[j][col] - dp[i - 1][col];
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }

    private int[][] createDpMatrix(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        return dp;
    }

}
