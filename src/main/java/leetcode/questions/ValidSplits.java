package leetcode.questions;

public class ValidSplits {

    public int waysToSplitArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }
        long[] prefixSums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i] = nums[i] + (i == 0 ? 0 : prefixSums[i - 1]);
        }
        int ways = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long leftSum = prefixSums[i];
            long rightSum = prefixSums[prefixSums.length - 1] - leftSum;
            if (leftSum >= rightSum) {
                ways++;
            }
        }
        return ways;
    }

}
