package leetcode.questions;

public class RemoveValueInPlace {

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int numsIndex = 0;
        int resultIndex = 0;
        while (numsIndex < nums.length) {
            if (nums[numsIndex] != val) {
                nums[resultIndex] = nums[numsIndex];
                resultIndex++;
            }
            numsIndex++;
        }
        return resultIndex;
    }

}
