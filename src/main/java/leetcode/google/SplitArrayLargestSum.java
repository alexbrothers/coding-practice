package leetcode.google;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length < m) {
            throw new IllegalArgumentException();
        }
        int[] prefixSums = new int[nums.length + 1];
        for (int i = 1; i < prefixSums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
        return splitArrayHelper(prefixSums, m, 0, new Integer[m - 1][nums.length]);
    }

    private int splitArrayHelper(int[] prefixSums, int m, int lastEnd, Integer[][] memo) {
        if (m == 1) {
            return prefixSums[prefixSums.length - 1] - prefixSums[lastEnd];
        }
        if (memo[m - 2][lastEnd] != null) {
            return memo[m - 2][lastEnd];
        }
        int minimumLargestSum = Integer.MAX_VALUE;
        for (int i = lastEnd + 1; i < prefixSums.length - m + 1; i++) {
            int sum = prefixSums[i] - prefixSums[lastEnd];
            if (sum >= minimumLargestSum) {
                break;
            }
            sum = Math.max(sum, splitArrayHelper(prefixSums, m - 1, i, memo));
            minimumLargestSum = Math.min(minimumLargestSum, sum);
        }
        memo[m - 2][lastEnd] = minimumLargestSum;
        return minimumLargestSum;
    }

}
