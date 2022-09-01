package leetcode.questions;

public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix[0].length - col - 1];
                matrix[row][matrix[0].length - col - 1] = temp;
            }
        }
    }

}
