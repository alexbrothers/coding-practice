package leetcode.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ReduceArraySizeToHalf {

    public int minSetSize(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry.getValue());
        }
        int count = 0;
        int removed = 0;
        while (!maxHeap.isEmpty()) {
            removed += maxHeap.poll();
            count++;
            if (removed >= arr.length / 2) {
                break;
            }
        }
        return count;
    }

}
