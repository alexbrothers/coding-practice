package leetcode.questions;

public class MinimumPartitions {

    public int minPartitions(String n) {
        if (n == null || n.length() < 1) {
            throw new IllegalArgumentException();
        }
        int maxDigit = '0';
        for (int i = 0; i < n.length(); i++) {
            maxDigit = (char) Math.max(maxDigit, n.charAt(i));
        }
        return maxDigit - '0';
    }

}
