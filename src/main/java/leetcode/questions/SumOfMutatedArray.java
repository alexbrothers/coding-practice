package leetcode.questions;

import java.util.Arrays;

public class SumOfMutatedArray {

    public int findBestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(arr);
        int[] prefix = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int prev = i == 0 ? 0 : prefix[i - 1];
            prefix[i] = arr[i] + prev;
        }
        int left = 0;
        int right = arr[arr.length - 1];
        int firstLessThanLeft = 0;
        int firstLessThanRight = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int answer = 0;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int index = findFirstLessThanIndex(arr, mid, firstLessThanLeft, firstLessThanRight);
            int sum = (index < 0 ? 0 : prefix[index]) + ((prefix.length - index - 1) * mid);
            int diff = Math.abs(target - sum);
            if (diff < minDiff || (diff == minDiff && mid < answer)) {
                minDiff = diff;
                answer = mid;
                if (left == right) {
                    break;
                }
            }
            if (sum >= target) {
                right = mid - 1;
                firstLessThanRight = index;
            }
            else {
                left = mid + 1;
                firstLessThanLeft = index + 1;
            }
        }
        return answer;
    }

    private int findFirstLessThanIndex(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (arr[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right;
    }

}
