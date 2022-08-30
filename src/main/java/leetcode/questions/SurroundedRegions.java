package leetcode.questions;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            throw new IllegalArgumentException();
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j] && shouldFlip(board, i, j, visited)) {
                    flip(board, i, j);
                }
            }
        }
    }

    private boolean shouldFlip(char[][] board, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (board[row][col] == 'X' || visited[row][col]) {
            return true;
        }
        visited[row][col] = true;
        boolean up = shouldFlip(board, row - 1, col, visited);
        boolean right = shouldFlip(board, row, col + 1, visited);
        boolean down = shouldFlip(board, row + 1, col, visited);
        boolean left = shouldFlip(board, row, col - 1, visited);
        return up && right && down && left;
    }

    private void flip(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'X') {
            return;
        }
        board[row][col] = 'X';
        flip(board, row - 1, col);
        flip(board, row, col + 1);
        flip(board, row + 1, col);
        flip(board, row, col - 1);
    }

}
