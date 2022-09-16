package leetcode.questions;

public class BuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        int[][] dp = new int[k + 1][prices.length];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            int minSoFar = Integer.MAX_VALUE;
            for (int j = 1; j < dp[0].length; j++) {
                minSoFar = Math.min(minSoFar, prices[j - 1] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 1], prices[j] - minSoFar));
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
