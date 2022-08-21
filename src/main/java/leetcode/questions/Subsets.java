package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsets(nums, 0, i, new ArrayList<>(), result);
        }
        return result;
    }

    private void subsets(int[] nums, int index, int targetSize, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == targetSize) {
            result.add(new ArrayList<>(current));
            return;
        }
        int numsRemaining = targetSize - current.size();
        for (int i = index; i < nums.length - numsRemaining + 1; i++) {
            current.add(nums[i]);
            subsets(nums, i + 1, targetSize, current, result);
            current.remove(current.size() - 1);
        }
    }

}
