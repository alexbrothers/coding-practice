package leetcode.questions;

public class FirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int findLeft(int[] nums, int target, int left, int right) {
        int mid = left + ((right - left) / 2);
        if (mid == 0) {
            return mid;
        }
        if (nums[mid] != target) {
            return findLeft(nums, target, mid + 1, right);
        }
        if (nums[mid - 1] != target) {
            return mid;
        }
        else {
            return findLeft(nums, target, left, mid - 1);
        }
    }

    private int findRight(int[] nums, int target, int left, int right) {
        int mid = left + ((right - left) / 2);
        if (mid == nums.length - 1) {
            return mid;
        }
        if (nums[mid] != target) {
            return findRight(nums, target, left, mid - 1);
        }
        if (nums[mid + 1] != target) {
            return mid;
        }
        else {
            return findRight(nums, target, mid + 1, right);
        }
    }

    private int[] binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        int mid = left + ((right - left) / 2);
        if (nums[mid] == target) {
            return new int[]{findLeft(nums, target, left, right), findRight(nums, target, left, right)};
        }
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        }
        else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }

}
