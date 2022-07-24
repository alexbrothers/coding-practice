package leetcode.linkedin;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationsUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> converted = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(converted, 0, result);
        return result;
    }

    private void permuteUnique(List<Integer> nums, int index, List<List<Integer>> result) {
        if (index == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        Set<Integer> starts = new HashSet<>();
        for (int i = index; i < nums.size(); i++) {
            if (starts.contains(nums.get(i))) {
                continue;
            }
            starts.add(nums.get(i));
            Collections.swap(nums, index, i);
            permuteUnique(nums, index + 1, result);
            Collections.swap(nums, i, index);
        }
    }

}
