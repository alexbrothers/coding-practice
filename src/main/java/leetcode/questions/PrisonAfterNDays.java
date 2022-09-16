package leetcode.questions;

import java.util.HashMap;

public class PrisonAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int n) {
        if (cells == null || cells.length == 0 || n < 0) {
            throw new IllegalArgumentException();
        }
        HashMap<String, Integer> map = new HashMap<>();
        boolean fastForward = false;
        int days = 0;
        while (days < n) {
            if (!fastForward) {
                String key = cellsToString(cells);
                if (map.containsKey(key)) {
                    int prev = map.get(key);
                    int stepsInBetween = days - prev;
                    int remaining = (n - days) % stepsInBetween;
                    days = n - remaining;
                    fastForward = true;
                }
                else {
                    map.put(key, days);
                }
            }
            if (days < n) {
                int[] temp = new int[cells.length];
                for (int i = 1; i < cells.length - 1; i++) {
                    if ((cells[i - 1] == 1 && cells[i + 1] == 1) || (cells[i - 1] == 0 && cells[i + 1] == 0)) {
                        temp[i] = 1;
                    }
                    else {
                        temp[i] = 0;
                    }
                }
                cells = temp;
                days++;
            }
        }
        return cells;
    }

    private String cellsToString(int[] cells) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            stringBuilder.append(cells[i]);
        }
        return stringBuilder.toString();
    }

}
