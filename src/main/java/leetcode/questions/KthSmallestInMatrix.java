package leetcode.questions;

public class KthSmallestInMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int start = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix.length - 1];
        while (start < end) {
            int[] minMax = new int[]{start, end};
            int mid = start + ((end - start) / 2);
            int count = count(matrix, mid, minMax);
            if (count == k) {
                return minMax[0];
            }
            else if (count < k) {
                start = minMax[1];
            }
            else {
                end = minMax[0];
            }
        }
        return start;
    }

    public int count(int[][] matrix, int target, int[] minMax) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int value = matrix[row][col];
            if (value <= target) {
                count += row + 1;
                col++;
                minMax[0] = Math.max(minMax[0], value);
            }
            else {
                row--;
                minMax[1] = Math.min(minMax[1], value);
            }
        }
        return count;
    }

}
