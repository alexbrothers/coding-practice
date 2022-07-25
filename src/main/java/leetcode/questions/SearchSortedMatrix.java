package leetcode.questions;

public class SearchSortedMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int current = matrix[row][col];
            if (current == target) {
                return true;
            }
            if (current > target) {
                row--;
            }
            else {
                col++;
            }
        }
        return false;
    }

}
