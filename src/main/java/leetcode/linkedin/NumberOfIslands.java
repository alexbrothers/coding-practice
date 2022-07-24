package leetcode.linkedin;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    removeIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void removeIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        removeIsland(grid, row - 1, col);
        removeIsland(grid, row, col + 1);
        removeIsland(grid, row + 1, col);
        removeIsland(grid, row, col - 1);
    }

}
