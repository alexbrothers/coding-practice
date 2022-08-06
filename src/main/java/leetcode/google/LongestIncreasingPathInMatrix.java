package leetcode.google;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        Integer[][] memo = new Integer[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, dfs(matrix, i, j, Integer.MIN_VALUE, memo, visited));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int row, int col, int prev, Integer[][] memo, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || visited[row][col] || matrix[row][col] <= prev) {
            return 0;
        }
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        visited[row][col] = true;
        int result = Math.max(
                dfs(matrix, row - 1, col, matrix[row][col], memo, visited),
                Math.max(
                        dfs(matrix, row + 1, col, matrix[row][col], memo, visited),
                        Math.max(
                                dfs(matrix, row, col - 1, matrix[row][col], memo, visited),
                                dfs(matrix, row, col + 1, matrix[row][col], memo, visited)
                        )
                )
        );
        memo[row][col] = result + 1;
        visited[row][col] = false;
        return result + 1;
    }

}
