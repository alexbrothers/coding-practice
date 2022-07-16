package leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class MatchsticksToSquare {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null) {
            throw new IllegalArgumentException();
        }
        if (matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int target = sum / 4;
        return canMakeSquare(matchsticks, 0, target, new int[4]);
    }

    private boolean canMakeSquare(int[] matchsticks, int index, int target, int[] sides) {
        if (index >= matchsticks.length) {
            return isSquare(sides, target);
        }
        int matchstickLength = matchsticks[index];
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + matchstickLength <= target) {
                sides[i] += matchstickLength;
                if (!sums.contains(sides[i]) && canMakeSquare(matchsticks, index + 1, target, sides)) {
                    return true;
                }
                sums.add(sides[i]);
                sides[i] -= matchstickLength;
            }
        }
        return false;
    }

    private boolean isSquare(int[] sides, int target) {
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] != target) {
                return false;
            }
        }
        return true;
    }

}
