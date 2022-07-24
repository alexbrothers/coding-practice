package leetcode.google;

import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null) {
            throw new IllegalArgumentException();
        }
        if (height.length < 3) {
            return 0;
        }
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            int currentHeight = height[i];
            while (!stack.isEmpty() && currentHeight > height[stack.peek()]) {
                int popped = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                area += (Math.min(currentHeight, height[stack.peek()]) - height[popped]) * distance;
            }
            stack.push(i);
        }
        return area;
    }

}
