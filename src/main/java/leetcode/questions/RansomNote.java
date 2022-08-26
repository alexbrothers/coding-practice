package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        return canConstructHelper(magazine, countNoteLetters(ransomNote));
    }

    private Map<Character, Integer> countNoteLetters(String note) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < note.length(); i++) {
            map.put(note.charAt(i), map.getOrDefault(note.charAt(i), 0) + 1);
        }
        return map;
    }

    private boolean canConstructHelper(String magazine, Map<Character, Integer> letters) {
        for (int i = 0; i < magazine.length(); i++) {
            char current = magazine.charAt(i);
            if (letters.containsKey(current)) {
                int count = letters.get(current);
                if (count == 1) {
                    letters.remove(current);
                }
                else {
                    letters.put(current, count - 1);
                }
            }
        }
        return letters.isEmpty();
    }

}
