package leetcode.google;

public class PeakIndexInMountain {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException();
        }
        return findPeak(arr, 0, arr.length - 1);
    }

    private int findPeak(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) / 2);
        if (mid == 0) {
            return findPeak(arr, mid + 1, right);
        }
        if (mid == arr.length - 1) {
            return findPeak(arr, left, mid - 1);
        }
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        else if (arr[mid] < arr[mid - 1]) {
            return findPeak(arr, left, mid - 1);
        }
        else {
            return findPeak(arr, mid + 1, right);
        }
    }

}
