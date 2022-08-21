package leetcode.questions;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                row--;
            }
            else {
                col++;
            }
        }
        return false;
    }

}
