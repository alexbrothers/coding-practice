package leetcode.questions;

public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int[] dp = new int[s.length()];
        int bCount = 0;
        for (int i = 0; i < dp.length; i++) {
            char current = s.charAt(i);
            if (current == 'a') {
                dp[i] = Math.min(i - 1 >= 0 ? dp[i - 1] + 1 : 0, bCount);
            }
            else {
                dp[i] = i - 1 >= 0 ? dp[i - 1] : 0;
                bCount++;
            }
        }
        return dp[dp.length - 1];
    }

}
