package leetcode.questions;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                max = Math.max(max, countAreaOfIsland(grid, i, j));
            }
        }
        return max;
    }

    private int countAreaOfIsland(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 + countAreaOfIsland(grid, row - 1, col) + countAreaOfIsland(grid, row, col + 1) +
                countAreaOfIsland(grid, row + 1, col) + countAreaOfIsland(grid, row, col - 1);
    }

}
