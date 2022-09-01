package leetcode.questions;

import java.util.*;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        if (s.length() <= 10) {
            return result;
        }
        StringBuilder stringBuilder = buildInitial(s);
        Map<String, Integer> seen = new HashMap<>();
        seen.put(stringBuilder.toString(), 1);
        for (int i = 10; i < s.length(); i++) {
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(s.charAt(i));
            String dna = stringBuilder.toString();
            seen.put(dna, seen.getOrDefault(dna, 0) + 1);
            if (seen.get(dna) == 2) {
                result.add(dna);
            }
        }
        return result;
    }

    private StringBuilder buildInitial(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder;
    }

}
