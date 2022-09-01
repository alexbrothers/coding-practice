package leetcode.questions;

import java.util.Arrays;

public class ShortestDistanceMaze {

    private int[][] directions = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            throw new IllegalArgumentException();
        }
        int[][] dp = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[start[0]][start[1]] = 0;
        explore(maze, start[0], start[1], destination[0], destination[1], dp);
        return dp[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dp[destination[0]][destination[1]];
    }

    private void explore(int[][] maze, int row, int col, int rowDestination, int colDestination, int[][] dp) {
        if (row == rowDestination && col == colDestination) {
            return;
        }
        int steps = dp[row][col];
        for (int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            int count = 0;
            int nextRow = row;
            int nextCol = col;
            while (canMoveInDirection(maze, nextRow, nextCol, direction)) {
                count++;
                nextRow += direction[0];
                nextCol += direction[1];
            }
            if (steps + count < dp[nextRow][nextCol]) {
                dp[nextRow][nextCol] = steps + count;
                explore(maze, nextRow, nextCol, rowDestination, colDestination, dp);
            }
        }
    }

    private boolean canMoveInDirection(int[][] maze, int row, int col, int[] direction) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];
        return nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length && maze[nextRow][nextCol] == 0;
    }


}
