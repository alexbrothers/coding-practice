package leetcode.questions;

import java.util.*;

public class MovesToStamp {

    public int[] movesToStamp(String stamp, String target) {
        if (stamp == null || target == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder targetCopy = new StringBuilder(target);
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> moves = new Stack<>();
        int replaced = 0;
        for (int i = 0; i <= targetCopy.length() - stamp.length(); i++) {
            if (isMatch(stamp, targetCopy, i)) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            moves.add(index);
            replaced += replace(targetCopy, stamp, index);
            if (replaced == target.length()) {
                break;
            }
            for (int i = index + 1; i <= targetCopy.length() - stamp.length() && i < index + stamp.length(); i++) {
                if (isMatch(stamp, targetCopy, i)) {
                    queue.add(i);
                }
            }
            int leftStart = index - stamp.length() + 1;
            for (int i = leftStart < 0 ? 0 : leftStart; i < index; i++) {
                if (isMatch(stamp, targetCopy, i)) {
                    queue.add(i);
                }
            }
        }
        if (replaced != target.length()) {
            return new int[]{};
        }
        return convertStack(moves);
    }

    private int[] convertStack(Stack<Integer> stack) {
        int index = 0;
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()) {
            result[index] = stack.pop();
            index++;
        }
        return result;
    }

    private int replace(StringBuilder target, String stamp, int index) {
        int count = 0;
        for (int i = index; i < index + stamp.length(); i++) {
            char current = target.charAt(i);
            if (current == '*') {
                continue;
            }
            target.replace(i, i + 1, "*");
            count++;
        }
        return count;
    }

    private boolean isMatch(String stamp, StringBuilder target, int index) {
        int nonWildCardCount = 0;
        for (int i = 0; i < stamp.length(); i++) {
            char stampChar = stamp.charAt(i);
            char targetChar = target.charAt(index + i);
            if (targetChar == '*') {
                continue;
            }
            nonWildCardCount++;
            if (stampChar != targetChar) {
                return false;
            }
        }
        return nonWildCardCount > 0;
    }

}
