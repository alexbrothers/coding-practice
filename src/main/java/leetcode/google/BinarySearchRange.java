package leetcode.google;

public class BinarySearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        return findRange(nums, 0, nums.length - 1, target);
    }

    private int[] findRange(int[] nums, int left, int right, int target) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        int mid = left + ((right - left) / 2);
        if (nums[mid] == target) {
            return new int[]{findLeft(nums, left, mid, target), findRight(nums, mid, right, target)};
        }
        else if (nums[mid] < target) {
            return findRange(nums, mid + 1, right, target);
        }
        else {
            return findRange(nums, left, mid - 1, target);
        }
    }

    private int findLeft(int[] nums, int left, int right, int target) {
        int mid = left + ((right - left) / 2);
        if (nums[mid] != target) {
            return findLeft(nums, mid + 1, right, target);
        }
        else {
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            }
            else {
                return findLeft(nums, left, mid - 1, target);
            }
        }
    }

    private int findRight(int[] nums, int left, int right, int target) {
        int mid = left + ((right - left) / 2);
        if (nums[mid] != target) {
            return findRight(nums, left, mid - 1, target);
        }
        else {
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                return mid;
            }
            else {
                return findRight(nums, mid + 1, right, target);
            }
        }
    }

}
