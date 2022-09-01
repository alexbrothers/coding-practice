package leetcode.questions;

public class MinimumSideJumps {

    public int minSideJumps(int[] obstacles) {
        if (obstacles == null || obstacles.length == 0) {
            throw new IllegalArgumentException();
        }
        return minSideJumps(obstacles, 0, 2, new Integer[obstacles.length][4]);
    }

    private int minSideJumps(int[] obstacles, int index, int currentLane, Integer[][] memo) {
        if (index == obstacles.length - 1) {
            return 0;
        }
        if (obstacles[index] == currentLane) {
            return Integer.MAX_VALUE;
        }
        if (memo[index][currentLane] != null) {
            return memo[index][currentLane];
        }
        int result;
        if (obstacles[index + 1] == currentLane) {
            if (currentLane == 1) {
                result = 1 + Math.min(
                        minSideJumps(obstacles, index, 2, memo),
                        minSideJumps(obstacles, index, 3, memo)
                );
            }
            else if (currentLane == 2) {
                result = 1 + Math.min(
                        minSideJumps(obstacles, index, 1, memo),
                        minSideJumps(obstacles, index, 3, memo)
                );
            }
            else {
                result = 1 + Math.min(
                        minSideJumps(obstacles, index, 1, memo),
                        minSideJumps(obstacles, index, 2, memo)
                );
            }
        }
        else {
            result = 0 + minSideJumps(obstacles, index + 1, currentLane, memo);
        }
        memo[index][currentLane] = result;
        return result;
    }

}
