package leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                setRow(matrix, i);
            }
        }
        for (int i = 0; i < columns.length; i++) {
            if (columns[i]) {
                setColumn(matrix, i);
            }
        }
    }

    private void setColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    private void setRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

}
