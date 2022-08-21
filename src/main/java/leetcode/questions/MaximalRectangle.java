package leetcode.questions;

import java.util.Arrays;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        Arrays.fill(right, matrix[0].length);
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                }
                else {
                    height[j]++;
                }
            }
            int currentLeft = 0;
            for (int j = 0; j < left.length; j++) {
                if (matrix[i][j] == '0') {
                    left[j] = 0;
                    currentLeft = j + 1;
                }
                else {
                    left[j] = Math.max(left[j], currentLeft);
                }
            }
            int currentRight = right.length;
            for (int j = right.length - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    right[j] = right.length;
                    currentRight = j;
                }
                else {
                    right[j] = Math.min(right[j], currentRight);
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                maxArea = Math.max(maxArea, height[j] * (right[j] - left[j]));
            }
        }
        return maxArea;
    }

}
