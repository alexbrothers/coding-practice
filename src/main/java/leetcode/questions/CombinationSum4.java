package leetcode.questions;

public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        Integer[] memo = new Integer[target];
        return findCombinations(nums, 0, 0, target, memo);
    }

    private int findCombinations(int[] nums, int index, int currentSum, int target, Integer[] memo) {
        if (currentSum == target) {
            return 1;
        }
        if (currentSum > target) {
            return 0;
        }
        if (memo[currentSum] != null) {
            return memo[currentSum];
        }
        int ways = 0;
        for (int i = 0; i < nums.length; i++) {
            ways += findCombinations(nums, i, currentSum + nums[i], target, memo);
        }
        memo[currentSum] = ways;
        return ways;
    }

}
