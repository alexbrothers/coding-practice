package leetcode.questions;

import java.util.PriorityQueue;

public class DiagonalSort {

    public int[][] diagonalSort(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException();
        }
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = mat[0].length; i >= 0; i--) {
            fillResultDiagonal(mat, 0, i, result, new PriorityQueue<>((a, b) -> Integer.compare(b, a)));
        }
        for (int i = 1; i < mat.length; i++) {
            fillResultDiagonal(mat, i, 0, result, new PriorityQueue<>((a, b) -> Integer.compare(b, a)));
        }
        return result;
    }

    private void fillResultDiagonal(int[][] mat, int row, int col, int[][] result, PriorityQueue<Integer> diagonal) {
        if (row >= mat.length || col >= mat[0].length) {
            return;
        }
        diagonal.offer(mat[row][col]);
        fillResultDiagonal(mat, row + 1, col + 1, result, diagonal);
        result[row][col] = diagonal.poll();
    }

}
