package leetcode.questions;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int sortedIndex = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                count = 1;
            }
            else {
                count++;
            }
            if (count <= 2) {
                nums[sortedIndex] = nums[i];
                sortedIndex++;
            }
        }
        return sortedIndex;
    }

}
