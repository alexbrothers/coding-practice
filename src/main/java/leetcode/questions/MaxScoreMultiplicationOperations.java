package leetcode.questions;

public class MaxScoreMultiplicationOperations {

    public int maximumScore(int[] nums, int[] multipliers) {
        if (nums == null || multipliers == null || nums.length < multipliers.length) {
            throw new IllegalArgumentException();
        }
        return maxScoreHelper(nums, 0, nums.length - 1, multipliers, 0, new Integer[multipliers.length][multipliers.length]);
    }

    private int maxScoreHelper(int[] nums, int left, int right, int[] multipliers, int index, Integer[][] memo) {
        if (index == multipliers.length) {
            return 0;
        }
        if (memo[left][index] != null) {
            return memo[left][index];
        }
        int multiplier = multipliers[index];
        int max = Math.max(
                (nums[left] * multiplier) + maxScoreHelper(nums, left + 1, right, multipliers, index + 1, memo),
                (nums[right] * multiplier) + maxScoreHelper(nums, left, right - 1, multipliers, index + 1, memo)
        );
        memo[left][index] = max;
        return max;
    }

}
