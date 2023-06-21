package leetcode.questions;

public class WaysToDecode {

    public int numDecodings(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        return numDecodingsHelper(s, 0, new Integer[s.length()]);
    }

    private int numDecodingsHelper(String s, int index, Integer[] memo) {
        if (index == s.length()) {
            return 1;
        }
        if (index > s.length()) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        int oneResult = isValidOne(s.charAt(index)) ? numDecodingsHelper(s, index + 1, memo) : 0;
        int twoResult = index + 1 < s.length() && isValidTwo(s.charAt(index), s.charAt(index + 1)) ? numDecodingsHelper(s, index + 2, memo) : 0;
        memo[index] = oneResult + twoResult;
        return oneResult + twoResult;
    }

    private boolean isValidOne(char digit) {
        return digit != '0';
    }

    private boolean isValidTwo(char char1, char char2) {
        if (char1 == '0') {
            return false;
        }
        if (char1 == '1') {
            return true;
        }
        return char1 == '2' && char2 <= '6';
    }

}
