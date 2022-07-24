package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left = incrementLeft(nums, left, right);
                    right = decrementRight(nums, right, left);
                }
                else if (sum > 0) {
                    right = decrementRight(nums, right, left);
                }
                else {
                    left = incrementLeft(nums, left, right);
                }
            }
        }
        return result;
    }

    private int incrementLeft(int[] nums, int left, int right) {
        do {
            left++;
        } while (left < right && nums[left] == nums[left - 1]);
        return left;
    }

    private int decrementRight(int[] nums, int right, int left) {
        do {
            right--;
        } while (left < right && nums[right] == nums[right + 1]);
        return right;
    }

}
