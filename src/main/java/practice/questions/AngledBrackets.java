package practice.questions;

import java.util.Stack;

public class AngledBrackets {

    public static String solution(String angles) {
        if (angles == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int addBeginning = 0;
        for (int i = 0; i < angles.length(); i++) {
            char current = angles.charAt(i);
            if (current == '>') {
                if (stack.isEmpty()) {
                    addBeginning++;
                }
                else {
                    stack.pop();
                }
            }
            else {
                stack.push('<');
            }
        }
        for (int i = 0; i < addBeginning; i++) {
            stringBuilder.append('<');
        }
        stringBuilder.append(angles);
        while (!stack.isEmpty()) {
            stack.pop();
            stringBuilder.append('>');
        }
        return stringBuilder.toString();
    }

}
