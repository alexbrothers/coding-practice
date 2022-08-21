package leetcode.questions;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int[][] matrix = new int[n][n];
        int startNum = 1;
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            startNum = fill(startRow, endRow, startCol, endCol, startNum, matrix);
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return matrix;
    }

    private int fill(int startRow, int endRow, int startCol, int endCol, int startNum, int[][] matrix) {
        for (int i = startCol; i <= endCol; i++) {
            matrix[startRow][i] = startNum;
            startNum++;
        }
        if (startRow == endRow) {
            return startNum;
        }
        for (int i = startRow + 1; i <= endRow; i++) {
            matrix[i][endCol] = startNum;
            startNum++;
        }
        if (startCol == endCol) {
            return startNum;
        }
        for (int i = endCol - 1; i >= startCol; i--) {
            matrix[endRow][i] = startNum;
            startNum++;
        }
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            matrix[i][startCol] = startNum;
            startNum++;
        }
        return startNum;
    }

}
