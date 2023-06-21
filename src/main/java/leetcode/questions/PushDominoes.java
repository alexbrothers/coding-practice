package leetcode.questions;

import java.util.Arrays;

public class PushDominoes {

    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0) {
            throw new IllegalArgumentException();
        }
        int[] closestRight = new int[dominoes.length()];
        int[] closestLeft = new int[dominoes.length()];
        int maxRight = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                maxRight = i;
            }
            else if (dominoes.charAt(i) == '.') {
                if (maxRight == -1) {
                    closestRight[i] = -1;
                }
                else {
                    closestRight[i] = i - maxRight;
                }
            }
            else {
                maxRight = -1;
            }
        }
        int minLeft = -1;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                minLeft = i;
            }
            else if (dominoes.charAt(i) == '.') {
                if (minLeft == -1) {
                    closestLeft[i] = -1;
                }
                else {
                    closestLeft[i] = minLeft - i;
                }
            }
            else {
                minLeft = -1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(dominoes);
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == '.') {
                if (closestRight[i] == -1 && closestLeft[i] == -1) {
                    continue;
                }
                else if (closestRight[i] == -1) {
                    stringBuilder.replace(i, i + 1, "L");
                }
                else if (closestLeft[i] == -1) {
                    stringBuilder.replace(i, i + 1, "R");
                }
                else {
                    if (closestRight[i] < closestLeft[i]) {
                        stringBuilder.replace(i, i + 1, "R");
                    }
                    else if (closestLeft[i] < closestRight[i]) {
                        stringBuilder.replace(i, i + 1, "L");
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

}
