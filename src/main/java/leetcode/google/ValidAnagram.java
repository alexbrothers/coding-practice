package leetcode.google;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() != t.length()) {
            return false;
        }
        return areAnagrams(characterMap(s), characterMap(t));
    }

    private int[] characterMap(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            counts[current - 'a']++;
        }
        return counts;
    }

    private boolean areAnagrams(int[] counts1, int[] counts2) {
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }
        return true;
    }

}
