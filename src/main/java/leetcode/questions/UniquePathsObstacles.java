package leetcode.questions;

public class UniquePathsObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            throw new IllegalArgumentException();
        }
        Integer[][] dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                int left = dp[i][j - 1] == null ? 0 : dp[i][j - 1];
                int top = dp[i - 1][j] == null ? 0 : dp[i - 1][j];
                dp[i][j] = left + top;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == null ? 0 : dp[dp.length - 1][dp[0].length - 1];
    }

}
