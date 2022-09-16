package leetcode.questions;

import java.util.Arrays;

public class NumberOfWeakCharacters {

    public int numberOfWeakCharacters(int[][] properties) {
        if (properties == null || properties.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(properties, (a, b) -> {
            int attack = Integer.compare(a[0], b[0]);
            if (attack == 0) {
                return Integer.compare(b[1], a[1]);
            }
            return attack;
        });
        int weakCharacters = 0;
        int maxDefence = 0;
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < maxDefence) {
                weakCharacters++;
            }
            maxDefence = Math.max(maxDefence, properties[i][1]);
        }
        return weakCharacters;
    }

}
