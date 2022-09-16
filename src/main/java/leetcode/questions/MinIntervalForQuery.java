package leetcode.questions;

import java.util.*;

public class MinIntervalForQuery {

    class Interval {
        int size;
        int left;
        int right;

        Interval(int size, int left, int right) {
            this.size = size;
            this.left = left;
            this.right = right;
        }
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        if (intervals == null || queries == null) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[queries.length];
        Map<Integer, List<Integer>> queryIndexes = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            List<Integer> indexes = queryIndexes.getOrDefault(queries[i], new ArrayList<>());
            indexes.add(i);
            queryIndexes.put(queries[i], indexes);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(queries);
        int index = 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.size));
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            while (index < intervals.length && intervals[index][0] <= target) {
                int left = intervals[index][0];
                int right = intervals[index][1];
                minHeap.add(new Interval(right - left + 1, left, right));
                index++;
            }
            while (!minHeap.isEmpty() && !isInRange(minHeap.peek().left, minHeap.peek().right, target)) {
                minHeap.poll();
            }
            List<Integer> indexes = queryIndexes.get(target);
            result[indexes.remove(indexes.size() - 1)] = minHeap.isEmpty() ? -1 : minHeap.peek().size;
            queryIndexes.put(target, indexes);
        }
        return result;
    }

    private boolean isInRange(int left, int right, int target) {
        return left <= target && right >= target;
    }

}
