package leetcode.questions;

import java.util.*;

public class BagOfTokensScore {

    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens == null) {
            throw new IllegalArgumentException();
        }
        int maxScore = 0;
        int score = 0;
        Arrays.sort(tokens);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            deque.addLast(tokens[i]);
        }
        while (!deque.isEmpty()) {
            while (!deque.isEmpty() && power >= deque.peekFirst()) {
                int tokenUsed = deque.pollFirst();
                power -= tokenUsed;
                score++;
                maxScore = Math.max(maxScore, score);
            }
            if (score == 0) {
                break;
            }
            if (!deque.isEmpty()) {
                power += deque.pollLast();
                score--;
            }
        }
        return maxScore;
    }

}
