package leetcode.linkedin;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException();
        }
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int pivotIndex = start;
        int pivot = nums[pivotIndex];
        int left = start + 1;
        int right = end;
        while (left <= right) {
            if (nums[left] < pivot) {
                left++;
            }
            else if (nums[right] >= pivot) {
                right--;
            }
            else {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (nums.length - k == right) {
            return pivot;
        }
        swap(nums, pivotIndex, right);
        if (nums.length - k > right) {
            return quickSelect(nums, k, right + 1, end);
        }
        else {
            return quickSelect(nums, k, start, right - 1);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
