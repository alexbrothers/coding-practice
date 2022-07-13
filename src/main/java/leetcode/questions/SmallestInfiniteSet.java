package leetcode.questions;

import java.util.*;

public class SmallestInfiniteSet {

    private Set<Integer> popped;
    private PriorityQueue<Integer> nums;

    public SmallestInfiniteSet() {
        popped = new HashSet<>();
        nums = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            nums.add(i);
        }
    }

    public int popSmallest() {
        int result = nums.poll();
        popped.add(result);
        return result;
    }

    public void addBack(int num) {
        if (!popped.contains(num)) {
            return;
        }
        popped.remove(num);
        nums.add(num);
    }

}
