package leetcode.questions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumSquareDifference {

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        if (nums1 == null || nums2 == null || nums1.length != nums2.length) {
            throw new IllegalArgumentException();
        }
        if (nums1.length == 0) {
            return 0;
        }
        Map<Long, Long> diffs = new HashMap<>();
        long highestDiff = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            long diff = Math.abs(nums1[i] - nums2[i]);
            diffs.put(diff, diffs.getOrDefault(diff, 0L) + 1);
            highestDiff = Math.max(highestDiff, diff);
        }
        int changes = k1 + k2;
        while (changes > 0 && highestDiff != 0) {
            long count = diffs.get(highestDiff);
            if (count > changes) {
                diffs.put(highestDiff, count - changes);
                diffs.put(highestDiff - 1, diffs.getOrDefault(highestDiff - 1, 0L) + changes);
            }
            else {
                diffs.remove(highestDiff);
                diffs.put(highestDiff - 1, diffs.getOrDefault(highestDiff - 1, 0L) + count);
                highestDiff -= 1;
            }
            changes -= count;
        }
        long result = 0;
        for (Map.Entry<Long, Long> entry : diffs.entrySet()) {
            result += (entry.getKey() * entry.getKey()) * entry.getValue();
        }
        return result;
    }

}
