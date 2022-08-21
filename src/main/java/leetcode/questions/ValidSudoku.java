package leetcode.questions;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException();
        }
        // validate rows
        for (int i = 0; i < board.length; i++) {
            int[] counts = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                if (counts[num - 1] != 0) {
                    return false;
                }
                counts[num - 1]++;
            }
        }
        // validate columns
        for (int i = 0; i < board[0].length; i++) {
            int[] counts = new int[9];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int num = board[j][i] - '0';
                if (counts[num - 1] != 0) {
                    return false;
                }
                counts[num - 1]++;
            }
        }
        // validate squares
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if (!isSquareValid(board, i, i + 3, j, j + 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSquareValid(char[][] board, int startRow, int endRow, int startCol, int endCol) {
        int[] counts = new int[9];
        for (int i = startCol; i < endCol; i++) {
            for (int j = startRow; j < endRow; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                if (counts[num - 1] != 0) {
                    return false;
                }
                counts[num - 1]++;
            }
        }
        return true;
    }

}
