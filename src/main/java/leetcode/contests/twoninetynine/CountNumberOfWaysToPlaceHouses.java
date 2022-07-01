package leetcode.contests.twoninetynine;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfWaysToPlaceHouses {

    public int countHousePlacements(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int[][] map = new int[2][n];
        return countHousePlacementsHelper(map, 0, 0);
    }

    private int countHousePlacementsHelper(int[][] map, int row, int column) {
        if (column >= map[0].length) {
            return 1;
        }
        boolean canFromLeft = true;
        boolean canFromRight = true;
        if (column - 1 >= 0 && map[row][column - 1] == 1) {
            canFromLeft = false;
        }
        if (column + 1 < map[0].length && map[row][column + 1] == 1) {
            canFromRight = false;
        }
        int waysWith = 0;
        int waysWithout = 0;
        if (canFromLeft && canFromRight) {
            map[row][column] = 1;
            if (row == 0) {
                waysWith = countHousePlacementsHelper(map, 1, column);
            } else {
                waysWith = countHousePlacementsHelper(map, 0, column + 1);
            }
        }
        map[row][column] = 0;
        if (row == 0) {
            waysWithout = countHousePlacementsHelper(map, 1, column);
        } else {
            waysWithout = countHousePlacementsHelper(map, 0, column + 1);
        }
        return waysWith + waysWithout;
    }

}
