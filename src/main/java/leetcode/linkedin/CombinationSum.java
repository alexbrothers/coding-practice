package leetcode.linkedin;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            throw new IllegalArgumentException();
        }
        int[] nums = sortAndRemoveDuplicates(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(nums, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSumHelper(int[] nums, int index, int target, List<Integer> currentNums, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentNums));
            return;
        }
        if (target < 0 || index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int currentNum = nums[i];
            currentNums.add(currentNum);
            combinationSumHelper(nums, i, target - currentNum, currentNums, result);
            currentNums.remove(currentNums.size() - 1);
        }
    }

    private int[] sortAndRemoveDuplicates(int[] candidates) {
        int[] counts = new int[200];
        int uniqueNumbers = 0;
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            if (counts[num - 1] == 0) {
                counts[num - 1]++;
                uniqueNumbers++;
            }
        }
        int[] sorted = new int[uniqueNumbers];
        int sortedIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                sorted[sortedIndex] = i + 1;
                sortedIndex++;
            }
        }
        return sorted;
    }

}
