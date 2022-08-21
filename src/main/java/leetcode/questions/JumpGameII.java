package leetcode.questions;

public class JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int jumps = 0;
        int steps = 0;
        int maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
            steps--;
        }
        return jumps;
    }

}
