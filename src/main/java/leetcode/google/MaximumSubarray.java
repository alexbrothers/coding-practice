package leetcode.google;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > currentSum + num) {
                currentSum = num;
            }
            else {
                currentSum += num;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}
