package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetNoDups {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int lastStart = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            int start = isDuplicate(nums, i) ? lastStart : 0;
            for (int j = start; j < size; j++) {
                List<Integer> current = new ArrayList<>(result.get(j));
                current.add(nums[i]);
                result.add(current);
            }
            lastStart = size;
        }
        return result;
    }

    private boolean isDuplicate(int[] nums, int index) {
        return index > 0 && nums[index] == nums[index - 1];
    }

}
