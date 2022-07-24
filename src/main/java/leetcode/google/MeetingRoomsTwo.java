package leetcode.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MeetingRoomsTwo {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        TreeMap<Integer, Integer> endTimes = new TreeMap<>();
        int rooms = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] meeting = intervals[i];
            int start = meeting[0];
            int end = meeting[1];
            if (endTimes.isEmpty()) {
                endTimes.put(end, 1);
                rooms++;
            }
            else {
                Integer nextEnd = endTimes.floorKey(start);
                if (nextEnd == null) {
                    rooms++;
                    endTimes.put(end, endTimes.getOrDefault(end, 0) + 1);
                }
                else {
                    int count = endTimes.get(nextEnd);
                    if (count == 1) {
                        endTimes.remove(nextEnd);
                    }
                    else {
                        endTimes.put(nextEnd, count - 1);
                    }
                    endTimes.put(end, endTimes.getOrDefault(end, 0) + 1);
                }
            }
        }
        return rooms;
    }

}
