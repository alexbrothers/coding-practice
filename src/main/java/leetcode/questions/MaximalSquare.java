package leetcode.questions;

import java.util.Arrays;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        Arrays.fill(right, matrix[0].length);
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                }
                else {
                    height[j]++;
                }
            }
            int currentLeft = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    left[j] = 0;
                    currentLeft = j + 1;
                }
                else {
                    left[j] = Math.max(left[j], currentLeft);
                }
            }
            int currentRight = matrix[0].length;
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    right[j] = matrix[0].length;
                    currentRight = j;
                }
                else {
                    right[j] = Math.min(right[j], currentRight);
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                int minDimension = Math.min(height[j], right[j] - left[j]);
                if (minDimension == 1) {
                    maxArea = Math.max(maxArea, minDimension);
                }
                else {
                    maxArea = Math.max(maxArea, minDimension * minDimension);
                }
            }
        }
        return maxArea;
    }

}
