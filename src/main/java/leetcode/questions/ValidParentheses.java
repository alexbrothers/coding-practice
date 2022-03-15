package leetcode.questions;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatch(stack.pop(), currentChar)) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isMatch(Character open, Character close) {
        if (open == '(' && close != ')') {
            return false;
        }
        if (open == '[' && close != ']') {
            return false;
        }
        if (open == '{' && close != '}') {
            return false;
        }
        return true;
    }

}
