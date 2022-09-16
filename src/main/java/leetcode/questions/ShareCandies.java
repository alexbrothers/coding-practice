package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class ShareCandies {

    public int shareCandies(int[] candies, int k) {
        if (candies == null || candies.length == 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = k; i < candies.length; i++) {
            map.put(candies[i], map.getOrDefault(candies[i], 0) + 1);
        }
        int max = map.size();
        if (k == 0) {
            return max;
        }
        for (int i = k; i < candies.length; i++) {
            int currentCandy = candies[i];
            int currentCandyCount = map.get(currentCandy);
            if (currentCandyCount == 1) {
                map.remove(currentCandy);
            }
            else {
                map.put(currentCandy, currentCandyCount - 1);
            }
            int candyAdded = candies[i - k];
            map.put(candyAdded, map.getOrDefault(candyAdded, 0) + 1);
            max = Math.max(max, map.size());
        }
        return max;
    }

}
