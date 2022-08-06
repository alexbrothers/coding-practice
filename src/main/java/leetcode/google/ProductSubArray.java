package leetcode.google;

public class ProductSubArray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int max = maxSoFar;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int maxProduct = Math.max(maxSoFar * num, minSoFar * num);
            int minProduct = Math.min(maxSoFar * num, minSoFar * num);
            maxSoFar = Math.max(num, maxProduct);
            minSoFar = Math.min(num, minProduct);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }

}
