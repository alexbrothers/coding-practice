package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            spiral(matrix, startRow, endRow, startCol, endCol, result);
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }

    private void spiral(int[][] matrix, int startRow, int endRow, int startCol, int endCol, List<Integer> result) {
        for (int i = startCol; i <= endCol; i++) {
            result.add(matrix[startRow][i]);
        }
        if (startRow == endRow) {
            return;
        }

        for (int i = startRow + 1; i <= endRow; i++) {
            result.add(matrix[i][endCol]);
        }
        if (startCol == endCol) {
            return;
        }

        for (int i = endCol - 1; i >= startCol; i--) {
            result.add(matrix[endRow][i]);
        }
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            result.add(matrix[i][startCol]);
        }
    }

}
