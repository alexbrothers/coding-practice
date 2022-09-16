package leetcode.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TransformStringToAnother {

    public boolean canConvert(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            throw new IllegalArgumentException();
        }
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        boolean result = canConvert(str1, str2, 0, map);
        return result && new HashSet<>(map.values()).size() < 26;
    }

    private boolean canConvert(String str1, String str2, int index, Map<Character, Character> conversions) {
        if (index == str1.length()) {
            return true;
        }
        char current = str1.charAt(index);
        char target = str2.charAt(index);
        if (conversions.containsKey(current)) {
            if (conversions.get(current) != target) {
                return false;
            }
        }
        else {
            conversions.put(current, target);
        }
        return canConvert(str1, str2, index + 1, conversions);
    }

}
