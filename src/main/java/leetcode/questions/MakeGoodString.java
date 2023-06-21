package leetcode.questions;

import java.util.Stack;

public class MakeGoodString {

    public String makeGood(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stack.isEmpty() && isMatch(current, stack.peek())) {
                stack.pop();
            }
            else {
                stack.push(current);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    private boolean isMatch(char char1, char char2) {
        return (Character.isUpperCase(char1) && Character.isLowerCase(char2) && Character.toLowerCase(char1) == char2) ||
                (Character.isLowerCase(char1) && Character.isUpperCase(char2) && Character.toUpperCase(char1) == char2);
    }

}
