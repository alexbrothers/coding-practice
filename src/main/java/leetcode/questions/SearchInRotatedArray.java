package leetcode.questions;

public class SearchInRotatedArray {

    public boolean search(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = left + ((right - left) / 2);
        int value = nums[mid];
        if (value == target) {
            return true;
        }
        if (value == nums[left] && value == nums[right]) { // can't decide which side of shift
            return search(nums, target, left, mid - 1) || search(nums, target, mid + 1, right);
        }
        if (value <= nums[right]) { // on right side of shift
            if (value < target && target <= nums[right]) {
                return search(nums, target, mid + 1, right);
            }
            else {
                return search(nums, target, left, mid - 1);
            }
        }
        else {
            if (value > target && target >= nums[left]) {
                return search(nums, target, left, mid - 1);
            }
            else {
                return  search(nums, target, mid + 1, right);
            }
        }
    }

}
