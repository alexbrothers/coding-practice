package leetcode.questions;

import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int poppedIndex = stack.pop();
                int start = stack.isEmpty() ? 0 : stack.peek() + 1;
                max = Math.max(max, heights[poppedIndex] * (i - start));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int poppedIndex = stack.pop();
            int start = stack.isEmpty() ? 0 : stack.peek() + 1;
            max = Math.max(max, heights[poppedIndex] * (heights.length - start));
        }
        return max;
    }

}
