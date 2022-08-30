package leetcode.questions;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = Arrays.copyOf(nums1, m);
        int index1 = 0;
        int index2 = 0;
        while (index1 < m && index2 < n) {
            if (copy[index1] < nums2[index2]) {
                nums1[index1 + index2] = copy[index1];
                index1++;
            }
            else {
                nums1[index1 + index2] = nums2[index2];
                index2++;
            }
        }
        while (index1 < m) {
            nums1[index1 + index2] = copy[index1];
            index1++;
        }
        while (index2 < n) {
            nums1[index1 + index2] = nums2[index2];
            index2++;
        }
    }

}
