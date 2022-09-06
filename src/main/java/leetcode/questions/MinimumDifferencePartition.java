package leetcode.questions;

public class MinimumDifferencePartition {

    public int minimumDifference(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        return minimumDifferenceHelper(nums, 0, nums.length / 2, 0, sum(nums));
    }

    private int minimumDifferenceHelper(int[] nums, int index, int numsNeeded, int currentSum, int sum) {
        if (numsNeeded == 0) {
            return Math.abs(currentSum - (sum - currentSum));
        }
        if (index == nums.length || nums.length - index < numsNeeded) {
            return Integer.MAX_VALUE;
        }
        int num = nums[index];
        return Math.min(
                minimumDifferenceHelper(nums, index + 1, numsNeeded - 1, currentSum + num, sum),
                minimumDifferenceHelper(nums, index + 1, numsNeeded, currentSum, sum)
        );
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
