package leetcode.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || truckSize < 0) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt((int[] box) -> box[1]).reversed());
        for (int i = 0; i < boxTypes.length; i++) {
            maxHeap.add(boxTypes[i]);
        }
        int units = 0;
        int numBoxes = 0;
        while (!maxHeap.isEmpty() && numBoxes < truckSize) {
            int[] currentBox = maxHeap.poll();
            int numBoxesThatCanFit = Math.min(truckSize - numBoxes, currentBox[0]);
            units += numBoxesThatCanFit * currentBox[1];
            numBoxes += numBoxesThatCanFit;
        }
        return units;
    }

}
