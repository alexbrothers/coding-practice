package leetcode.linkedin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> replacements = new HashMap<>();
        Set<Character> replaced = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if (replacements.containsKey(sChar)) {
                if (replacements.get(sChar) != tChar) {
                    return false;
                }
            }
            else {
                if (replaced.contains(tChar)) {
                    return false;
                }
                replacements.put(sChar, tChar);
                replaced.add(tChar);
            }
        }
        return true;
    }

}
