package leetcode.questions;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        return Math.max(forward(s), backward(s));
    }

    private int forward(String s) {
        int max = 0;
        int currentCount = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(current);
            }
            else {
                if (stack.isEmpty()) {
                    currentCount = 0;
                }
                else {
                    stack.pop();
                    currentCount += 2;
                    max = Math.max(max, currentCount);
                }
            }
        }
        return max;
    }

    private int backward(String s) {
        int max = 0;
        int currentCount = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);
            if (current == ')') {
                stack.push(current);
            }
            else {
                if (stack.isEmpty()) {
                    currentCount = 0;
                }
                else {
                    stack.pop();
                    currentCount += 2;
                    max = Math.max(max, currentCount);
                }
            }
        }
        return max;
    }

}
