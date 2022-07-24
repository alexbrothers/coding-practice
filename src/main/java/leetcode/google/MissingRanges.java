package leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper) {
                result.add("" + lower);
            }
            else {
                result.add(lower + "->" + upper);
            }
            return result;
        }
        if (lower < nums[0]) {
            if (lower + 1 == nums[0]) {
                result.add("" + lower);
            }
            else {
                result.add(lower + "->" + (nums[0] - 1));
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int left = nums[i];
            int right = nums[i + 1];
            if (left == right || left + 1 == right) {
                continue;
            }
            else {
                if (left + 2 == right) {
                    result.add("" + (left + 1));
                }
                else {
                    result.add((left + 1) + "->" + (right - 1));
                }
            }
        }
        if (upper > nums[nums.length - 1]) {
            if (upper - 1 == nums[nums.length - 1]) {
                result.add("" + upper);
            }
            else {
                result.add(nums[nums.length - 1] + 1 + "->" + upper);
            }
        }
        return result;
    }

}
