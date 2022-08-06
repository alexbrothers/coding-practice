package leetcode.google;

public class LongestPalindrone {

    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        int[] maxLength = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            int[] oddLength = expandFromCenter(s, i, i);
            int[] evenLength = expandFromCenter(s, i, i + 1);
            if (oddLength[1] - oddLength[0] > maxLength[1] - maxLength[0]) {
                maxLength[1] = oddLength[1];
                maxLength[0] = oddLength[0];
            }
            if (evenLength[1] - evenLength[0] > maxLength[1] - maxLength[0]) {
                maxLength[1] = evenLength[1];
                maxLength[0] = evenLength[0];
            }
        }
        return s.substring(maxLength[0], maxLength[1]);
    }

    private int[] expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }

}
