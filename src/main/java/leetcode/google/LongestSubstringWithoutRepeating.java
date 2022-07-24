package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        Map<Character, Integer> map = new HashMap<>();
        int currentStart = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (map.containsKey(current) && map.get(current) >= currentStart) {
                if (i - currentStart > maxLength) {
                    maxLength = i - currentStart;
                }
                currentStart = map.get(current) + 1;
            }
            map.put(current, i);
        }
        return s.length() - currentStart > maxLength ? s.length() - currentStart : maxLength;
    }

}
