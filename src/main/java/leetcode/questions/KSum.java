package leetcode.questions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KSum {

    public long kSum(int[] nums, int k) {
        long sum = 0;
        Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        for (int i = 0; i < nums.length; i++) {
            sum = sum + Math.max(0, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long result = sum;
        pq.offer(new long[]{sum - nums[0], 0});
        while (--k > 0) {
            long[] pair = pq.poll();
            result = pair[0];
            int index = (int) pair[1];
            if (index < nums.length - 1) {
                pq.offer(new long[]{result + nums[index] - nums[index + 1], index + 1});
                pq.offer(new long[]{result - nums[index + 1], index + 1});
            }
        }
        return result;
    }

}
