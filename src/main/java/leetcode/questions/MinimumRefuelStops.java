package leetcode.questions;

import java.util.PriorityQueue;

public class MinimumRefuelStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations == null) {
            throw new IllegalArgumentException();
        }
        if (stations.length == 0) {
            return startFuel >= target ? 0 : -1;
        }
        if (startFuel < stations[0][0]) {
            return -1;
        }
        int refuels = 0;
        int fuel = startFuel - stations[0][0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < stations.length; i++) {
            int[] station = stations[i];
            int currentPosition = station[0];
            int nextPosition = i == stations.length - 1 ? target : stations[i + 1][0];
            maxHeap.add(station[1]);
            while (currentPosition + fuel < nextPosition) {
                if (maxHeap.isEmpty()) {
                    return -1;
                }
                fuel += maxHeap.poll();
                refuels++;
            }
            fuel = fuel - (nextPosition - currentPosition);
        }
        return refuels;
    }

}
