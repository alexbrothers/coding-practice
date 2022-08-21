package leetcode.questions;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[dp.length - 1];
    }

}
