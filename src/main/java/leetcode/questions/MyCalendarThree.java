package leetcode.questions;

import java.util.Map;
import java.util.TreeMap;

class MyCalendarThree {

    private TreeMap<Integer, Integer> treeMap;

    public MyCalendarThree() {
        this.treeMap = new TreeMap<>();
    }

    public int book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        int max = 0;
        int overlappingBookings = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            overlappingBookings += entry.getValue();
            max = Math.max(max, overlappingBookings);
        }
        return max;
    }
}
