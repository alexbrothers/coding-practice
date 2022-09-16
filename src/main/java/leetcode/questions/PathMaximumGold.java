package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class PathMaximumGold {

    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, maxGold(grid, i, j));
                }
            }
        }
        return max;
    }

    private int maxGold(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        int prevValue = grid[row][col];
        grid[row][col] = 0;
        int max = Math.max(
                maxGold(grid, row - 1, col),
                Math.max(
                        maxGold(grid, row + 1, col),
                        Math.max(
                                maxGold(grid, row, col - 1),
                                maxGold(grid, row, col + 1)
                        )
                )
        );
        grid[row][col] = prevValue;
        return prevValue + max;
    }

}
