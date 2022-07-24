package leetcode.linkedin;

import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> originalCharacterCounts = countCharacterFrequencies(t);
        Map<Character, Integer> charactersNeeded = countCharacterFrequencies(t);
        Map<Character, Integer> currentCounts = new HashMap<>();
        boolean found = false;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (originalCharacterCounts.containsKey(current)) {
                currentCounts.put(current, currentCounts.getOrDefault(current, 0) + 1);
                if (charactersNeeded.containsKey(current)) {
                    int count = charactersNeeded.get(current);
                    count--;
                    if (count == 0) {
                        charactersNeeded.remove(current);
                    }
                    else {
                        charactersNeeded.put(current, count);
                    }
                }
                if (charactersNeeded.isEmpty()) {
                    found = true;
                    while (true) {
                        Character firstCharacter = s.charAt(start);
                        if (originalCharacterCounts.containsKey(firstCharacter)) {
                            int count = currentCounts.get(firstCharacter);
                            if (count > originalCharacterCounts.get(firstCharacter)) {
                                currentCounts.put(firstCharacter, count - 1);
                                start++;
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            start++;
                        }
                    }
                    if (i - start + 1 < minLength) {
                        minLength = i - start + 1;
                        minStart = start;
                    }
                    Character first = s.charAt(start);
                    currentCounts.put(first, currentCounts.get(first) - 1);
                    charactersNeeded.put(first, 1);
                    start++;
                }
            }
        }
        return found ? s.substring(minStart, minStart + minLength) : "";
    }

    private Map<Character, Integer> countCharacterFrequencies(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character current = t.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        return map;
    }

}
