package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        int start = 0;
        Character character1 = null;
        Character character2 = null;
        int character1LastIndex = 0;
        int character2LastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (current == character1) {
                character1LastIndex = i;
            }
            else if (current == character2) {
                character2LastIndex = i;
            }
            else if (character1 == null || character2 == null) {
                if (character1 == null) {
                    character1 = current;
                    character1LastIndex = i;
                }
                else {
                    character2 = current;
                    character2LastIndex = i;
                }
            }
            else {
                max = Math.max(max, i - start);
                if (s.charAt(i - 1) == character1) {
                    start = character2LastIndex + 1;
                    character2 = current;
                    character2LastIndex = i;
                }
                else {
                    start = character1LastIndex + 1;
                    character1 = current;
                    character1LastIndex = i;
                }
            }
        }
        max = Math.max(max, s.length() - start);
        return max;
    }

}
