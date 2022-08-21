package leetcode.questions;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - i - 1;
            }
        }
        return s.length();
    }

}
