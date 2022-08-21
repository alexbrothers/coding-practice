package leetcode.questions;

public class BinaryStringSeconds {

    public int secondsToRemoveOccurrences(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        int zeros = 0;
        int seconds = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '0') {
                zeros++;
            }
            else {
                if (zeros > 0) {
                    seconds = Math.max(seconds + 1, zeros);
                }
            }
        }
        return seconds;
    }

}
