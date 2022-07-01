package leetcode.questions;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {

    public int minMoves2(int[] nums) {
        if (nums ==  null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            moves += Math.abs(nums[i] - mid);
        }
        return moves;
    }

}
