package leetcode.questions;

import java.util.Arrays;
import java.util.Comparator;

public class IsCoveredByRange {

    public boolean isCovered(int[][] ranges, int left, int right) {
        if (ranges == null) {
            throw new IllegalArgumentException();
        }
        if (ranges.length == 0) {
            return false;
        }
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        if (ranges[0][0] > left) {
            return false;
        }
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            if (range[0] > left) {
                return false;
            }
            left = Math.max(left, range[1] + 1);
        }
        return left > right;
    }

}
