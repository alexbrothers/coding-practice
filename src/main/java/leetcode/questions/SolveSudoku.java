package leetcode.questions;

public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException();
        }
        int[][] rowNums = new int[9][9];
        int[][] colNums = new int[9][9];
        int[][] boxNums = new int[9][9];
        fill(board, rowNums, colNums, boxNums);
        solveSudoku(board, 0, 0, rowNums, colNums, boxNums);
    }

    private void fill(char[][] board, int[][] rowNums, int[][] colNums, int[][] boxNums) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int num = board[row][col] - '0';
                rowNums[row][num - 1]++;
                colNums[col][num - 1]++;
                boxNums[getBoxNumber(row, col)][num - 1]++;
            }
        }
    }

    private int getBoxNumber(int row, int col) {
        return ((row / 3) * 3) + (col / 3);
    }

    private boolean solveSudoku(char[][] board, int row, int col, int[][] rowNums, int[][] colNums, int[][] boxNums) {
        if (col >= board[0].length) {
            return solveSudoku(board, row + 1, 0, rowNums, colNums, boxNums);
        }
        if (row >= board.length) {
            return true;
        }
        char current = board[row][col];
        if (current != '.') {
            return solveSudoku(board, row, col + 1, rowNums, colNums, boxNums);
        }
        else {
            for (int i = 1; i <= 9; i++) {
                if (isValidMove(i, row, col, rowNums, colNums, boxNums)) {
                    add(i, row, col, rowNums, colNums, boxNums);
                    board[row][col] = (char) (i + '0');
                    if (solveSudoku(board, row, col + 1, rowNums, colNums, boxNums)) {
                        return true;
                    }
                    remove(i, row, col, rowNums, colNums, boxNums);
                }
            }
            board[row][col] = '.';
            return false;
        }
    }

    private void remove(int num, int row, int col, int[][] rowNums, int[][] colNums, int[][] boxNums) {
        rowNums[row][num - 1]--;
        colNums[col][num - 1]--;
        boxNums[getBoxNumber(row, col)][num - 1]--;
    }

    private void add(int num, int row, int col, int[][] rowNums, int[][] colNums, int[][] boxNums) {
        rowNums[row][num - 1]++;
        colNums[col][num - 1]++;
        boxNums[getBoxNumber(row, col)][num - 1]++;
    }

    private boolean isValidMove(int num, int row, int col, int[][] rowNums, int[][] colNums, int[][] boxNums) {
        return rowNums[row][num - 1] == 0 &&
                colNums[col][num - 1] == 0 &&
                boxNums[getBoxNumber(row, col)][num - 1] == 0;
    }

}
