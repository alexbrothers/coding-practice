package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class IsInterleave {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException();
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleaveHelper(0, 0, 0, s1, s2, s3, new HashMap<>());
    }

    private boolean isInterleaveHelper(int index1, int index2, int index3, String s1, String s2, String s3, Map<String, Boolean> memo) {
        String key = index1 + ":" + index2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (index3 == s3.length()) {
            return true;
        }
        Character current = s3.charAt(index3);
        if (index1 < s1.length() && s1.charAt(index1) == current) {
            if (isInterleaveHelper(index1 + 1, index2, index3 + 1, s1, s2, s3, memo)) {
                return true;
            }
        }
        if (index2 < s2.length() && s2.charAt(index2) == current) {
            if (isInterleaveHelper(index1, index2 + 1, index3 + 1, s1, s2, s3, memo)) {
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

}
