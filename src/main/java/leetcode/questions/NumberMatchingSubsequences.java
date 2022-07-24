package leetcode.questions;

import java.util.*;

public class NumberMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        if (s == null || words == null) {
            throw new IllegalArgumentException();
        }
        Map<Character, List<String>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            List<String> wordsWithStartingLetter = map.getOrDefault(current.charAt(0), new ArrayList<>());
            wordsWithStartingLetter.add(current.substring(1));
            map.put(current.charAt(0), wordsWithStartingLetter);
        }
        for (int i = 0; i < s.length() && !map.isEmpty(); i++) {
            Character current = s.charAt(i);
            if (map.containsKey(current)) {
                List<String> candidates = map.remove(current);
                for (int j = 0; j < candidates.size(); j++) {
                    String currentCandidate = candidates.get(j);
                    if (currentCandidate.length() == 0) {
                        count++;
                    }
                    else {
                        List<String> newCandidates = map.getOrDefault(currentCandidate.charAt(0), new ArrayList<>());
                        newCandidates.add(currentCandidate.substring(1));
                        map.put(currentCandidate.charAt(0), newCandidates);
                    }
                }
            }
        }
        return count;
    }

}
