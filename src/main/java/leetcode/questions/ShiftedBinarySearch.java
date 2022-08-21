package leetcode.questions;

public class ShiftedBinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) / 2);
        int value = nums[mid];
        if (value == target) {
            return mid;
        }
        // if value is on the right side of the shift
        if (value <= nums[right]) {
            if (value < target && target <= nums[right]) {
                return search(nums, target, mid + 1, right);
            }
            else {
                return search(nums, target, left, mid - 1);
            }
        }
        // if value is on left side of the shift
        else {
            if (value > target && target >= nums[left]) {
                return search(nums, target, left, mid - 1);
            }
            else {
                return search(nums, target, mid + 1, right);
            }
        }
    }

}
