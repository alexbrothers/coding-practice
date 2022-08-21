package leetcode.questions;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = left + ((right - left) / 2);
        int value = nums[mid];
        if (value == target) {
            return mid;
        }
        else if (value < target) {
            return search(nums, target, mid + 1, right);
        }
        else {
            return search(nums, target, 0, mid - 1);
        }
    }

}
