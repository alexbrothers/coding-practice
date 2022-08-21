package leetcode.questions;

public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
            else if (nums[i] == 1) {
                ones++;
            }
        }
        int index = 0;
        while (index < nums.length) {
            if (zeros > 0) {
                nums[index] = 0;
                zeros--;
            }
            else if (ones > 0) {
                nums[index] = 1;
                ones--;
            }
            else {
                nums[index] = 2;
            }
            index++;
        }
    }

}
