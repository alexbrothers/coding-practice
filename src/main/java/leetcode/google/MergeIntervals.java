package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (result.isEmpty() || !isOverlapping(result.get(result.size() - 1), currentInterval)) {
                result.add(currentInterval);
            }
            else {
                int[] first = result.remove(result.size() - 1);
                result.add(merge(first, currentInterval));
            }
        }
        int[][] resultIntervals = new int[result.size()][];
        result.toArray(resultIntervals);
        return resultIntervals;
    }

    private int[] merge(int[] interval1, int[] interval2) {
        return new int[]{Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
    }

    private boolean isOverlapping(int[] interval1, int[] interval2) {
        return interval1[1] >= interval2[0];
    }

}
