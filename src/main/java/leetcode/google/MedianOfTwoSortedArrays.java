package leetcode.google;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || (nums1.length == 0 && nums2.length == 0)) {
            throw new IllegalArgumentException();
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (nums1.length == 0) {
            return findMedianSingle(nums2);
        }
        int start = 0;
        int end = nums1.length;
        int half = (nums1.length + nums2.length) / 2;
        while (start <= end) {
            int mid1 = (start + end) / 2;
            int mid2 = half - mid1;
            int maxLeft1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int maxLeft2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int minRight1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
            int minRight2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((nums1.length + nums2.length) % 2 != 0) {
                    return Math.min(minRight1, minRight2);
                }
                else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            }
            else if (maxLeft1 > minRight2) {
                end = mid1 - 1;
            }
            else {
                start = mid1 + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    private double findMedianSingle(int[] nums) {
        if (nums.length % 2 != 0) {
            return nums[nums.length / 2];
        }
        else {
            return (nums[(nums.length / 2) - 1] + nums[nums.length / 2]) / 2.0;
        }
    }

}
