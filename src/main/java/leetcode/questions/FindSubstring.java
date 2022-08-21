package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        Map<String, Integer> wordsNeeded = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            wordsNeeded.put(word, wordsNeeded.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            findSubstringHelper(s, i, wordLength, wordsNeeded, result);
        }
        return result;
    }

    private void findSubstringHelper(String s, int start, int wordLength, Map<String, Integer> wordsNeeded, List<Integer> result) {
        Map<String, Integer> copyWordsNeeded = new HashMap<>(wordsNeeded);
        int left = start;
        int right = start;
        while (left < s.length() - wordLength + 1 && right <= s.length() - wordLength) {
            String current = s.substring(right, right + wordLength);
            right += wordLength;
            if (copyWordsNeeded.containsKey(current)) {
                int count = copyWordsNeeded.get(current);
                if (count == 1) {
                    copyWordsNeeded.remove(current);
                }
                else {
                    copyWordsNeeded.put(current, count - 1);
                }
                if (copyWordsNeeded.isEmpty()) {
                    result.add(left);
                    String firstUsed = s.substring(left, left + wordLength);
                    copyWordsNeeded.put(firstUsed, 1);
                    left += wordLength;
                }
            }
            else {
                if (!wordsNeeded.containsKey(current)) {
                    left = right;
                    copyWordsNeeded = new HashMap<>(wordsNeeded);
                }
                else {
                    while (left < right) {
                        String putBack = s.substring(left, left + wordLength);
                        left += wordLength;
                        if (putBack.equals(current)) {
                            break;
                        }
                        copyWordsNeeded.put(putBack, copyWordsNeeded.getOrDefault(putBack, 0) + 1);
                    }
                }
            }
        }
    }


}
