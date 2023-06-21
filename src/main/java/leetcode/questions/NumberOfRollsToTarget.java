package leetcode.questions;

public class NumberOfRollsToTarget {

    private static final int MOD = (int) Math.pow(10, 9) + 7;

    public int numRollsToTarget(int n, int k, int target) {
        return numRolls(n, k, 0, target, new Integer[n + 1][target + 1]);
    }

    private int numRolls(int rolls, int faces, int sum, int target, Integer[][] memo) {
        if (rolls == 0) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        if (memo[rolls][sum] != null) {
            return memo[rolls][sum];
        }
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            int newSum = sum + i;
            if (newSum > target) {
                break;
            }
            count = (count +  numRolls(rolls - 1, faces, newSum, target, memo)) % MOD;
        }
        memo[rolls][sum] = count;
        return count;
    }

}
