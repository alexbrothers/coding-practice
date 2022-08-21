package leetcode.questions;

public class RemoveDuplicatesInPlace {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int numsIndex = 0;
        int resultIndex = 0;
        while (numsIndex < nums.length) {
            if (numsIndex == 0 || nums[numsIndex] != nums[numsIndex - 1]) {
                nums[resultIndex] = nums[numsIndex];
                resultIndex++;
            }
            numsIndex++;
        }
        return resultIndex;
    }

}
