package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class ConcatenatedPalindromes {

    public int longestPalindrome(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> seen = new HashMap<>();
        int pairs = 0;
        int singles = 0;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            char letter1 = currentWord.charAt(0);
            char letter2 = currentWord.charAt(1);
            String reversed = String.valueOf(letter2) + letter1;
            if (seen.containsKey(reversed)) {
                int count = seen.get(reversed);
                if (count == 1) {
                    seen.remove(reversed);
                }
                else {
                    seen.put(reversed, count - 1);
                }
                pairs++;
                if (letter1 == letter2) {
                    singles--;
                }
            }
            else {
                seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);
                if (letter1 == letter2) {
                    singles++;
                }
            }
        }
        return (pairs * 4) + (singles > 0 ? 2 : 0);
    }

}
