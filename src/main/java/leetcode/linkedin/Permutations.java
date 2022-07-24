package leetcode.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> converted = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permute(converted, 0, result);
        return result;
    }

    private void permute(List<Integer> nums, int index, List<List<Integer>> result) {
        if (index == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, index, i);
            permute(nums, index + 1, result);
            Collections.swap(nums, i, index);
        }
    }

}
