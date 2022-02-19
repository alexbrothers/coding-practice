package dailybyte.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumToTarget {

    /**
     * Given a list of nums and a target, return all the unique combinations of nums that sum to target.
     *
     * Ex: Given the following nums and target...
     *
     * nums = [8, 2, 2, 4, 5, 6, 3]
     * target = 9
     * return [[2,2,5],[2,3,4],[3,6],[4,5]].
     */
    public List<List<Integer>> sumToTarget(List<Integer> nums, int target) {
        Collections.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        sumToTargetHelper(nums, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void sumToTargetHelper(List<Integer> nums, int target, int currentTarget, int currentIndex, List<Integer> currentNums, List<List<Integer>> result) {
        if (currentTarget == target) {
            result.add(new ArrayList<>(currentNums));
            return;
        }
        Integer lastRemoved = null;
        for (int i = currentIndex; i < nums.size(); i++) {
            if (currentTarget + nums.get(i) <= target) {
                if (lastRemoved == null || nums.get(i) != lastRemoved) {
                    currentNums.add(nums.get(i));
                    sumToTargetHelper(nums, target, currentTarget + nums.get(i), i + 1, currentNums, result);
                    lastRemoved = currentNums.remove(currentNums.size() - 1);
                }
            }
            else {
                break;
            }
        }
    }

}
