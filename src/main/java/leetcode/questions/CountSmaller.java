package leetcode.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class CountSmaller {

    class NumIndex {
        int num;
        int index;

        NumIndex(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    private NumIndex[] mergeSort(NumIndex[] nums, int left, int right, List<Integer> result) {
        if (left == right) {
            return new NumIndex[]{nums[left]};
        }
        int mid = left + ((right - left) / 2);
        NumIndex[] leftSorted = mergeSort(nums, left, mid, result);
        NumIndex[] rightSorted = mergeSort(nums, mid + 1, right, result);
        return merge(leftSorted, rightSorted, result);
    }

    private NumIndex[] merge(NumIndex[] leftSorted, NumIndex[] rightSorted, List<Integer> result) {
        NumIndex[] merged = new NumIndex[leftSorted.length + rightSorted.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        while (mergedIndex < merged.length) {
            if (leftIndex >= leftSorted.length) {
                merged[mergedIndex] = rightSorted[rightIndex];
                rightIndex++;
            }
            else if (rightIndex >= rightSorted.length) {
                NumIndex next = leftSorted[leftIndex];
                merged[mergedIndex] = next;
                leftIndex++;
                result.set(next.index, result.get(next.index) + rightIndex);
            }
            else {
                NumIndex leftNum = leftSorted[leftIndex];
                NumIndex rightNum = rightSorted[rightIndex];
                if (leftNum.num <= rightNum.num) {
                    merged[mergedIndex] = leftNum;
                    leftIndex++;
                    result.set(leftNum.index, result.get(leftNum.index) + rightIndex);
                }
                else {
                    merged[mergedIndex] = rightNum;
                    rightIndex++;
                }
            }
            mergedIndex++;
        }
        return merged;
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> result = new ArrayList<>();
        NumIndex[] numIndexes = new NumIndex[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result.add(0);
            numIndexes[i] = new NumIndex(nums[i], i);
        }
        mergeSort(numIndexes, 0, numIndexes.length - 1, result);
        return result;
    }

}
