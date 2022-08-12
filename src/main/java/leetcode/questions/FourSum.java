package leetcode.questions;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        fourSumHelper(nums, 0, 4, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void fourSumHelper(int[] nums, int index, int k, long currentSum, long targetSum, List<Integer> current, List<List<Integer>> result) {
        long average = (targetSum - currentSum) / k;
        if (nums[index] > average || nums[nums.length - 1] < average) {
            return;
        }
        if (k == 2) {
            List<int[]> last2 = twoSum(nums, targetSum - currentSum, index, nums.length - 1);
            for (int i = 0; i < last2.size(); i++) {
                int[] numsToAdd = last2.get(i);
                current.add(numsToAdd[0]);
                current.add(numsToAdd[1]);
                result.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
                current.remove(current.size() - 1);
            }
            return;
        }
        Integer last = null;
        for (int i = index; i < nums.length - (3 - current.size()); i++) {
            int num = nums[i];
            if (last != null && num == last) {
                continue;
            }
            current.add(num);
            fourSumHelper(nums, i + 1, k - 1, currentSum + num, targetSum, current, result);
            last = current.remove(current.size() - 1);
        }
    }

    private List<int[]> twoSum(int[] nums, long target, int start, int end) {
        List<int[]> result = new ArrayList<>();
        int left = start;
        int right = end;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if ((left != start && nums[left] == nums[left - 1]) || sum < target) {
                left++;
            }
            else if ((right != end && nums[right] == nums[right + 1]) || sum > target) {
                right--;
            }
            else {
                result.add(new int[]{nums[left], nums[right]});
                left++;
                right--;
            }
        }
        return result;
    }

}
