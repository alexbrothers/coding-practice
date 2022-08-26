package leetcode.questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        List<Integer> max = new ArrayList<>();
        max.add(nums[deque.peekFirst()]);
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            max.add(nums[deque.peekFirst()]);
        }
        int[] result = new int[max.size()];
        for (int i = 0; i < max.size(); i++) {
            result[i] = max.get(i);
        }
        return result;
    }

}
