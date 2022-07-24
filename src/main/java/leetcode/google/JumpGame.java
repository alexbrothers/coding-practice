package leetcode.google;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 1) {
            return true;
        }
        int closestCanReach = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= closestCanReach) {
                closestCanReach = i;
            }
        }
        return closestCanReach == 0;
    }

}
