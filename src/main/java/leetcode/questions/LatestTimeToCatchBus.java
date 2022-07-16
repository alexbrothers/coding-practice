package leetcode.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LatestTimeToCatchBus {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        Set<Integer> set = new HashSet<>();
        int latestAvailable = 0;
        int passengerIndex = 0;
        for (int i = 0; i < buses.length; i++) {
            int busCapacity = 0;
            while (passengerIndex < passengers.length && busCapacity < capacity && passengers[passengerIndex] <= buses[i]) {
                busCapacity++;
                if (!set.contains(passengers[passengerIndex] - 1)) {
                    latestAvailable = passengers[passengerIndex] - 1;
                }
                set.add(passengers[passengerIndex]);
                passengerIndex++;
            }
            if (busCapacity < capacity && !set.contains(buses[i])){
                latestAvailable = Math.max(latestAvailable, buses[i]);
            }
        }
        return latestAvailable;
    }

}
