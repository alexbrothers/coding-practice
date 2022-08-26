package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class MinimumRounds {

    public int minimumRounds(int[] tasks) {
        if (tasks == null || tasks.length == 0) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int rounds = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for (Integer count : map.values()) {
            if (count == 1) {
                return -1;
            }
            if (count % 3 == 0) {
                rounds += count / 3;
            }
            else {
                rounds += (count / 3) + 1;
            }
        }
        return rounds;
    }

}
