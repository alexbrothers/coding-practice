package leetcode.questions;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        int[] longest = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                    max = Math.max(max, longest[i]);
                }
            }
        }
        return max + 1;
    }

}
