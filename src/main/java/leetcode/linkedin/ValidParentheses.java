package leetcode.linkedin;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (current == '[' || current == '(' || current == '{') {
                stack.push(current);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popped = stack.pop();
                if (current == ']' && popped != '[' || current == '}' && popped != '{' || current == ')' && popped != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
