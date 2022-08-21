package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int index, int sum, List<Integer> nums, List<List<Integer>> result) {
        if (sum == 0) {
            result.add(new ArrayList<>(nums));
            return;
        }
        if (sum < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            nums.add(candidates[i]);
            combinationSum(candidates, i + 1, sum - candidates[i], nums, result);
            nums.remove(nums.size() - 1);
        }
    }

}
