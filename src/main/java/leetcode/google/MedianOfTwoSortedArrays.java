package leetcode.google;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException();
        }
        if (nums1.length > nums2.length) {
            return findMedianHelper(nums2, nums1, 0, nums2.length - 1, 0, nums1.length - 1);
        }
        else {
            return findMedianHelper(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
        }
    }

    private double findMedianHelper(int[] nums1, int[] nums2, int left1, int right1, int left2, int right2) {
        if (left1 > right1) {
            return findMedianSingle(nums2, left2, right2);
        }
        if (left2 > right2) {
            return findMedianSingle(nums1, left1, right1);
        }
        int index1 = (right1 + left1) / 2;
        int index2 = (right2 + left2) / 2;
        double median1 = findMedianSingle(nums1, left1, right1);
        double median2 = findMedianSingle(nums2, left2, right2);
        if (median1 == median2) {
            return median1;
        }
        if (median1 < median2) {
            return findMedianHelper(nums1, nums2, index1 + 1, right1, left2, index2);
        }
        else {
            return findMedianHelper(nums1, nums2, left1, index1, index2 + 1, right2);
        }
    }

    private double findMedianSingle(int[] nums, int left, int right) {
        boolean isOdd = (right - left) % 2 == 0;
        if (isOdd) {
            return nums[(right - left) / 2];
        }
        int index = (right - left) / 2;
        int num1 = nums[index];
        int num2 = nums[index + 1];
        return (num1 + num2) / 2.0;
    }

}
