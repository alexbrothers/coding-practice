package leetcode.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException();
        }
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                }
                else {
                    if (i > 0 && dp[i - 1][j] != Integer.MAX_VALUE) {
                        if (dp[i][j] == Integer.MAX_VALUE) {
                            dp[i][j] = dp[i - 1][j] + 1;
                        }
                        else {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                        }
                    }
                    if (j > 0 && dp[i][j - 1] != Integer.MAX_VALUE) {
                        if (dp[i][j] == Integer.MAX_VALUE) {
                            dp[i][j] = dp[i][j - 1] + 1;
                        }
                        else {
                            dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                        }
                    }
                }
            }
        }

        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                }
                else {
                    if (i + 1 < mat.length && dp[i + 1][j] != Integer.MAX_VALUE) {
                        if (dp[i][j] == Integer.MAX_VALUE) {
                            dp[i][j] = dp[i + 1][j] + 1;
                        }
                        else {
                            dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                        }
                    }
                    if (j + 1 < mat[0].length && dp[i][j + 1] != Integer.MAX_VALUE) {
                        if (dp[i][j] == Integer.MAX_VALUE) {
                            dp[i][j] = dp[i][j + 1] + 1;
                        }
                        else {
                            dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                        }
                    }
                }
            }
        }
        return dp;
    }

}
