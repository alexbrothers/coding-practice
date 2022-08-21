package leetcode.questions;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
