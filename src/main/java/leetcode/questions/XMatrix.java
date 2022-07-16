package leetcode.questions;

public class XMatrix {

    public boolean checkXMatrix(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException();
        }
        int startRow = 0;
        int endRow = grid.length - 1;
        int startCol = 0;
        int endCol = grid[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                int topValue = grid[startRow][col];
                int bottomValue = grid[endRow][col];
                boolean shouldBeNonZero = col == startCol || col == endCol;
                if (shouldBeNonZero) {
                    if (topValue == 0 || bottomValue == 0) {
                        return false;
                    }
                }
                else {
                    if (topValue != 0 || bottomValue != 0) {
                        return false;
                    }
                }
            }
            for (int row = startRow; row <= endRow; row++) {
                int leftValue = grid[row][startCol];
                int rightValue = grid[row][endCol];
                boolean shouldBeNonZero = row == startRow || row == endRow;
                if (shouldBeNonZero) {
                    if (leftValue == 0 || rightValue == 0) {
                        return false;
                    }
                }
                else {
                    if (leftValue != 0 || rightValue != 0) {
                        return false;
                    }
                }
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return true;
    }

}
