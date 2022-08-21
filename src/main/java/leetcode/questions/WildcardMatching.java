package leetcode.questions;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException();
        }
        return isMatch(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
    }

    private boolean isMatch(String s, String p, int sIndex, int pIndex, Boolean[][] memo) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (pIndex == p.length()) {
            return false;
        }
        if (memo[sIndex][pIndex] != null) {
            return memo[sIndex][pIndex];
        }
        boolean result = false;
        char pattern = p.charAt(pIndex);
        if (pattern != '*' && pattern != '?') {
            result = sIndex < s.length() &&
                    s.charAt(sIndex) == pattern && isMatch(s, p, sIndex + 1, pIndex + 1, memo);
        }
        else if (pattern == '?') {
            result = sIndex < s.length() &&
                    isMatch(s, p, sIndex + 1, pIndex + 1, memo);
        }
        else {
            result = isMatch(s, p, sIndex, pIndex + 1, memo) ||
                    (sIndex < s.length() && isMatch(s, p, sIndex + 1, pIndex, memo));
        }
        memo[sIndex][pIndex] = result;
        return result;
    }

}
