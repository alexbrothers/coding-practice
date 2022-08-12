package leetcode.questions;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null || p.length() == 0 || p.charAt(0) == '*') {
            throw new IllegalArgumentException();
        }
        return isMatchHelper(s, p, 0, 0, new Boolean[s.length() + 1][p.length()]);
    }

    private boolean isMatchHelper(String s, String p, int sIndex, int pIndex, Boolean[][] memo) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (pIndex == p.length()) {
            return false;
        }
        if (memo[sIndex][pIndex] != null) {
            return memo[sIndex][pIndex];
        }
        char pattern = p.charAt(pIndex);
        boolean isAsteriskAhead = pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*';
        boolean result;
        if (!isAsteriskAhead) {
            result = sIndex < s.length() && isMatch(s.charAt(sIndex), pattern) && isMatchHelper(s, p, sIndex + 1, pIndex + 1, memo);
        }
        else {
            if (sIndex < s.length() && isMatch(s.charAt(sIndex), pattern)) {
                result = isMatchHelper(s, p, sIndex + 1, pIndex, memo) ||
                        isMatchHelper(s, p, sIndex, pIndex + 2, memo);
            }
            else {
                result = isMatchHelper(s, p, sIndex, pIndex + 2, memo);
            }
        }
        memo[sIndex][pIndex] = result;
        return result;
    }

    private boolean isMatch(char a, char pattern) {
        return pattern == '.' || a == pattern;
    }

}
