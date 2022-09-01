package leetcode.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidPalindromeIII {

    public boolean isValidPalindrome(String s, int k) {
        return isPalindrome(s, 0, s.length() - 1, new Integer[s.length()][s.length()]) <= k;
    }

    private int isPalindrome(String s, int start, int end, Integer[][] memo) {
        if (start == end || start > end) {
            return 0;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        if (s.charAt(start) == s.charAt(end)) {
            int result = isPalindrome(s, start + 1, end - 1, memo);
            memo[start][end] = result;
            return result;
        }
        else {
            int min = 1 + Math.min(isPalindrome(s, start + 1, end, memo), isPalindrome(s, start, end - 1, memo));
            memo[start][end] = min;
            return min;
        }
    }

}
