package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class OutOfBoundsPaths {

    int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (m <= 0 || n <= 0 || maxMove < 0 || startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            throw new IllegalArgumentException();
        }
        return findPathsHelper(startRow, startColumn, m, n, maxMove, new Integer[m][n][maxMove + 1]) % mod;
    }

    private int findPathsHelper(int row, int col, int m, int n, int movesRemaining, Integer[][][] memo) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        if (movesRemaining <= 0) {
            return 0;
        }
        if (memo[row][col][movesRemaining] != null) {
            return memo[row][col][movesRemaining];
        }
        int top = (findPathsHelper(row - 1, col, m, n, movesRemaining - 1, memo) % mod);
        int right = (findPathsHelper(row, col + 1, m, n, movesRemaining - 1, memo) % mod);
        int bottom = (findPathsHelper(row + 1, col, m, n, movesRemaining - 1, memo) % mod);
        int left = (findPathsHelper(row, col - 1, m, n, movesRemaining - 1, memo) % mod);
        int topAndRight = (top + right) % mod;
        int bottomAndLeft = (bottom + left) % mod;
        int result = (topAndRight + bottomAndLeft) % mod;
        memo[row][col][movesRemaining] = result;
        return result;
    }

}
