package practice.confluent;

import java.util.concurrent.DelayQueue;

public class WildcardMatching {

//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//            throw new IllegalArgumentException();
//        }
//        if (s.length() < p.length() - 1) {
//            return false;
//        }
//        int index = p.indexOf('*');
//        if (index == -1) {
//            return s.equals(p);
//        }
//        return s.startsWith(p.substring(0, index)) && s.endsWith(p.substring(index + 1));
//    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException();
        }
        return isMatch(s, p, 0, 0, new Boolean[s.length() + 1][p.length()]);
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
        char patternCharacter = p.charAt(pIndex);
        boolean result = false;
        if (patternCharacter != '*' && patternCharacter != '?') {
            result = sIndex < s.length() && s.charAt(sIndex) == patternCharacter && isMatch(s, p, sIndex + 1, pIndex + 1, memo);
        }
        else if (patternCharacter == '?') {
            result = sIndex < s.length() && isMatch(s, p, sIndex + 1, pIndex + 1, memo);
        }
        else {
            result = isMatch(s, p, sIndex, pIndex + 1, memo) ||
                    sIndex < s.length() && isMatch(s, p, sIndex + 1, pIndex, memo);
        }
        memo[sIndex][pIndex] = result;
        return result;
    }

}
