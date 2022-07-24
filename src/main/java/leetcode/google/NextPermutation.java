package leetcode.google;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int swapped = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int nextLargest = nums.length - 1;
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (nums[j] > nums[i] && nums[j + 1] <= nums[i]) {
                        nextLargest = j;
                        break;
                    }
                }
                swap(nums, i, nextLargest);
                swapped = i;
                break;
            }
        }
        reverse(nums, swapped + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left >= 0 && left < nums.length && right >= 0 && right < nums.length && left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
