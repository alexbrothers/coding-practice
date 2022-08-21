package leetcode.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitArrayInSubsequences {

    public boolean isPossible(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        if (nums.length < 3) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Map<Integer, Integer> endings = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int count = map.get(current);
            if (count == 0) {
                continue;
            }
            if (endings.containsKey(current - 1)) {
                map.put(current, count - 1);
                int endingsCount = endings.get(current - 1);
                if (endingsCount == 1) {
                    endings.remove(current - 1);
                }
                else {
                    endings.put(current - 1, endingsCount - 1);
                }
                endings.put(current, endings.getOrDefault(current, 0) + 1);
            }
            else {
                Integer oneCount = map.get(current + 1);
                Integer twoCount = map.get(current + 2);
                if (oneCount != null && twoCount != null && oneCount > 0 && twoCount > 0) {
                    map.put(current + 1, oneCount - 1);
                    map.put(current + 2, twoCount - 1);
                    map.put(current, count - 1);
                    endings.put(current + 2, endings.getOrDefault(current + 2, 0) + 1);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

}
