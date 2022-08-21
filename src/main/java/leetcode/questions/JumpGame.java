package leetcode.questions;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 1) {
            return true;
        }
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        return true;
    }

}
