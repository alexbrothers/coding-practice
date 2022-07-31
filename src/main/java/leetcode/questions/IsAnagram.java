package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (!map.containsKey(current)) {
                return false;
            }
            int count = map.get(current);
            if (count == 1) {
                map.remove(current);
            }
            else {
                map.put(current, count - 1);
            }
        }
        return map.isEmpty();
    }

}
