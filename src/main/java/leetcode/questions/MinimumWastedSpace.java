package leetcode.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MinimumWastedSpace {

    private static final int MODULO = ((int) Math.pow(10, 9)) + 7;

    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        Long minTotalBoxSize = null;
        for (int i = 0; i < boxes.length; i++) {
            int[] currentBoxes = boxes[i];
            Arrays.sort(currentBoxes);
            if (currentBoxes[currentBoxes.length - 1] < packages[packages.length - 1]) {
                continue;
            }
            minTotalBoxSize = Math.min(minTotalBoxSize == null ? Long.MAX_VALUE : minTotalBoxSize, getTotalBoxSize(packages, currentBoxes));
        }
        if (minTotalBoxSize == null) {
            return -1;
        }
        long totalPackageSize = 0;
        for (int i = 0; i < packages.length; i++) {
            totalPackageSize += packages[i];
        }
        return (int) ((minTotalBoxSize - totalPackageSize) % MODULO);
    }

    private long getTotalBoxSize(int[] packages, int[] boxes) {
        long totalBoxSize = 0;
        int start = 0;
        for (int i = 0; i < boxes.length && start < packages.length; i++) {
            int boxSize = boxes[i];
            int index = binarySearch(packages, boxSize, start, packages.length - 1);
            if (index == -1) {
                continue;
            }
            long packagesCovered = index - start + 1;
            totalBoxSize += (packagesCovered * boxSize);
            start = index + 1;
        }
        return totalBoxSize;
    }

    private int binarySearch(int[] packages, int boxSize, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) / 2);
        if (packages[mid] > boxSize) {
            return binarySearch(packages, boxSize, left, mid - 1);
        }
        else {
            int rightSearch = binarySearch(packages, boxSize, mid + 1, right);
            return rightSearch == -1 ? mid : rightSearch;
        }
    }

}
