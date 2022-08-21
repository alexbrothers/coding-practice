package leetcode.questions;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exists(board, word, i, j, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, String word, int row, int col, int wordIndex, boolean[][] visited) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(wordIndex)) {
            return false;
        }
        visited[row][col] = true;
        boolean found =  exists(board, word, row - 1, col, wordIndex + 1, visited) ||
                exists(board, word, row, col + 1, wordIndex + 1, visited) ||
                exists(board, word, row + 1, col, wordIndex + 1, visited) ||
                exists(board, word, row, col - 1, wordIndex + 1, visited);
        if (found) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }

}
