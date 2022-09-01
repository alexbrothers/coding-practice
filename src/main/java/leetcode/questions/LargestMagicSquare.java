package leetcode.questions;

public class LargestMagicSquare {

    class PrefixCheck {
        int target;
        boolean allSame;

        PrefixCheck(int target, boolean allSame) {
            this.target = target;
            this.allSame = allSame;
        }
    }

    class Prefixes {
        int rowPrefix;
        int colPrefix;
        int diagonal1Prefix;
        int diagonal2Prefix;
    }

    public int largestMagicSquare(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException();
        }
        Prefixes[][] dp = new Prefixes[grid.length][grid[0].length];
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                Prefixes currentPrefix = new Prefixes();
                currentPrefix.rowPrefix = grid[row][col] + (col - 1 >= 0 ? dp[row][col - 1].rowPrefix : 0);
                currentPrefix.colPrefix = grid[row][col] + (row - 1 >= 0 ? dp[row - 1][col].colPrefix : 0);
                currentPrefix.diagonal1Prefix = grid[row][col] + ((row - 1 >= 0 && col - 1 >= 0) ? dp[row - 1][col - 1].diagonal1Prefix : 0);
                currentPrefix.diagonal2Prefix = grid[row][col] + ((row - 1 >= 0 && col + 1 < dp[0].length) ? dp[row - 1][col + 1].diagonal2Prefix : 0);
                dp[row][col] = currentPrefix;
            }
        }
        int maxSize = Math.min(grid.length, grid[0].length);
        for (int size = maxSize; size >= 2; size--) {
            for (int row = grid.length - 1; row >= size - 1; row--) {
                for (int col = grid[0].length - 1; col >= size - 1; col--) {
                    if (isMagicSquare(dp, row, col, size)) {
                        return size;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isMagicSquare(Prefixes[][] dp, int endRow, int endCol, int size) {
        int startRow = endRow - size;
        int startCol = endCol - size;
        PrefixCheck rows = rowsSame(dp, startRow, endRow, startCol, endCol);
        if (!rows.allSame) {
            return false;
        }
        PrefixCheck cols = colsSame(dp, startRow, endRow, startCol, endCol);
        if (!cols.allSame || cols.target != rows.target) {
            return false;
        }
        int diagonal1Sum = getDiagonal1Sum(dp, startRow, endRow, startCol, endCol);
        int diagonal2Sum = getDiagonal2Sum(dp, startRow, endRow, startCol, endCol);
        return diagonal1Sum == diagonal2Sum && diagonal1Sum == rows.target;
    }

    private PrefixCheck rowsSame(Prefixes[][] dp, int startRow, int endRow, int startCol, int endCol) {
        int target = dp[endRow][endCol].rowPrefix - (startCol >= 0 ? dp[endRow][startCol].rowPrefix : 0);
        for (int row = endRow - 1; row > startRow; row--) {
            if (dp[row][endCol].rowPrefix - (startCol >= 0 ? dp[row][startCol].rowPrefix : 0) != target) {
                return new PrefixCheck(target, false);
            }
        }
        return new PrefixCheck(target, true);
    }

    private PrefixCheck colsSame(Prefixes[][] dp, int startRow, int endRow, int startCol, int endCol) {
        int target = dp[endRow][endCol].colPrefix - (startRow >= 0 ? dp[startRow][endCol].colPrefix : 0);
        for (int col = endCol - 1; col > startCol; col--) {
            if (dp[endRow][col].colPrefix - (startRow >= 0 ? dp[startRow][col].colPrefix : 0) != target) {
                return new PrefixCheck(target, false);
            }
        }
        return new PrefixCheck(target, true);
    }

    private int getDiagonal1Sum(Prefixes[][] dp, int startRow, int endRow, int startCol, int endCol) {
        return dp[endRow][endCol].diagonal1Prefix - (startRow >= 0 && startCol >= 0 ? dp[startRow][startCol].diagonal1Prefix : 0);
    }

    private int getDiagonal2Sum(Prefixes[][] dp, int startRow, int endRow, int startCol, int endCol) {
        return dp[endRow][startCol + 1].diagonal2Prefix - (endCol + 1 < dp[0].length && startRow >= 0 ? dp[startRow][endCol + 1].diagonal2Prefix : 0);
    }

}
