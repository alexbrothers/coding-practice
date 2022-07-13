package leetcode.questions;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        if (nums == null || k < 1) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 0) {
            return 0;
        }
        int[] scores = new int[nums.length];
        Deque<Integer> dp = new LinkedList<>();
        scores[0] = nums[0];
        dp.addFirst(0);
        for (int i = 1; i < nums.length; i++) {
            if (dp.peekFirst() < i - k) {
                dp.pollFirst();
            }
            scores[i] = scores[dp.peekFirst()] + nums[i];
            while (!dp.isEmpty() && scores[i] >= scores[dp.peekLast()]) {
                dp.pollLast();
            }
            dp.addLast(i);
        }
        return scores[scores.length - 1];
    }

}
