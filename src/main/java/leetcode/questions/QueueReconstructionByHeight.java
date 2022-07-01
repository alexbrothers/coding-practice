package leetcode.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(people, Comparator.comparingInt((int[] a) -> a[0]).reversed().thenComparingInt(a -> a[1]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            result.add(people[i][1], people[i]);
        }
        int[][] converted = new int[people.length][];
        return result.toArray(converted);
    }



}
