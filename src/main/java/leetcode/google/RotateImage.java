package leetcode.google;

public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        if (matrix.length == 1) {
            return;
        }
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        while (startRow < endRow && startCol < endCol) {
            rotateHelper(matrix, startRow, endRow, startCol, endCol);
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }

    private void rotateHelper(int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        for (int i = 0; i < endCol - startCol; i++) {
            int temp = matrix[startRow][startCol + i];
            int moving = temp;
            temp = matrix[startRow + i][endCol];
            matrix[startRow + i][endCol] = moving;
            moving = temp;
            temp = matrix[endRow][endCol - i];
            matrix[endRow][endCol - i] = moving;
            moving = temp;
            temp = matrix[endRow - i][startCol];
            matrix[endRow - i][startCol] = moving;
            matrix[startRow][startCol + i] = temp;
        }
    }

}
