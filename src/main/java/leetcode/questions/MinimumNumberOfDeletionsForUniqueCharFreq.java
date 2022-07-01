package leetcode.questions;

public class MinimumNumberOfDeletionsForUniqueCharFreq {

    public int minDeletions(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() == 1) {
            return 0;
        }
        int deletions = 0;
        int[] letterCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int letter = s.charAt(i) - 'a';
            letterCounts[letter]++;
        }
        int[] finalLetterCounts = new int[s.length()];
        for (int i = 0; i < letterCounts.length; i++) {
            int currentLetterCount = letterCounts[i];
            if (currentLetterCount == 0) {
                continue;
            }
            while (currentLetterCount - 1 >= 0 && finalLetterCounts[currentLetterCount - 1] >= 1) {
                deletions++;
                currentLetterCount--;
            }
            if (currentLetterCount - 1 >= 0) {
                finalLetterCounts[currentLetterCount - 1] = 1;
            }
        }
        return deletions;
    }

}
