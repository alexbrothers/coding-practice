package leetcode.questions;

import java.util.*;

public class ShortestDistancesFromAllBuildings {

    class BuildingDistances {
        int numBuildings;
        int distance;
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException();
        }
        BuildingDistances[][] dp = new BuildingDistances[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = new BuildingDistances();
            }
        }
        List<int[]> buildingIndexes = buildingCoordinates(grid);
        for (int i = 0; i < buildingIndexes.size(); i++) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            Queue<int[]> queue = new LinkedList<>();
            fillQueue(grid, buildingIndexes.get(i)[0], buildingIndexes.get(i)[1], visited, queue);
            int distance = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int[] coordinates = queue.poll();
                    BuildingDistances current = dp[coordinates[0]][coordinates[1]];
                    current.distance += distance;
                    current.numBuildings++;
                    fillQueue(grid, coordinates[0], coordinates[1], visited, queue);
                }
                distance++;
            }
        }
        int min = -1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                BuildingDistances current = dp[i][j];
                if (current.numBuildings == buildingIndexes.size()) {
                    if (min == -1) {
                        min = current.distance;
                    }
                    else {
                        min = Math.min(min, current.distance);
                    }
                }
            }
        }
        return min;
    }

    private void fillQueue(int[][] grid, int row, int col, boolean[][] visited, Queue<int[]> queue) {
        if (row - 1 >= 0 && grid[row - 1][col] == 0 && !visited[row - 1][col]) {
            queue.add(new int[]{row - 1, col});
            visited[row - 1][col] = true;
        }
        if (row + 1 < grid.length && grid[row + 1][col] == 0 && !visited[row + 1][col]) {
            queue.add(new int[]{row + 1, col});
            visited[row + 1][col] = true;
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 0 && !visited[row][col - 1]) {
            queue.add(new int[]{row, col - 1});
            visited[row][col - 1] = true;
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == 0 && !visited[row][col + 1]) {
            queue.add(new int[]{row, col + 1});
            visited[row][col + 1] = true;
        }
    }

    private List<int[]> buildingCoordinates(int[][] grid) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

}
