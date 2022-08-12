package leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            throw new IllegalArgumentException();
        }
        List<int[]> temp = new ArrayList<>();
        int index = 0;
        boolean intervalAdded = false;
        while (index < intervals.length) {
            int[] next;
            if (intervalAdded || intervals[index][0] <= newInterval[0]) {
                next = intervals[index];
                index++;
            }
            else {
                next = newInterval;
                intervalAdded = true;
            }
            if (temp.isEmpty() || !isOverlapping(temp.get(temp.size() - 1), next)) {
                temp.add(next);
            }
            else {
                merge(temp, next);
            }
        }
        if (!intervalAdded) {
            if (temp.isEmpty() || !isOverlapping(temp.get(temp.size() - 1), newInterval)) {
                temp.add(newInterval);
            }
            else {
                merge(temp, newInterval);
            }
        }
        return convertToResult(temp);
    }

    private void merge(List<int[]> temp, int[] next) {
        int[] last = temp.get(temp.size() - 1);
        temp.set(temp.size() - 1, new int[]{Math.min(last[0], next[0]), Math.max(last[1], next[1])});
    }

    private boolean isOverlapping(int[] interval1, int[] interval2) {
        return interval1[1] >= interval2[0];
    }

    private int[][] convertToResult(List<int[]> temp) {
        int[][] result = new int[temp.size()][];
        temp.toArray(result);
        return result;
    }

}
