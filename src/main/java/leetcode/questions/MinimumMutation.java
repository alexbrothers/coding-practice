package leetcode.questions;

import java.util.*;

public class MinimumMutation {

    private static final char[] GENES = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length()) {
            throw new IllegalArgumentException();
        }
        if (bank == null || bank.length == 0) {
            return -1;
        }
        return minMutationHelper(start, end, new HashSet<>(List.of(bank)), new HashSet<>(), new HashMap<>());
    }

    private int minMutationHelper(String start, String end, Set<String> bank, Set<String> visited, Map<String, Integer> memo) {
        if (start.equals(end)) {
            return 0;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        if (visited.contains(start)) {
            return -1;
        }
        visited.add(start);
        int min = -1;
        StringBuilder startStringBuilder = new StringBuilder(start);
        for (int i = 0; i < start.length(); i++) {
            char current = start.charAt(i);
            for (int j = 0; j < GENES.length; j++) {
                if (current != GENES[j]) {
                    startStringBuilder.replace(i, i + 1, String.valueOf(GENES[j]));
                    if (bank.contains(startStringBuilder.toString())) {
                        int result = minMutationHelper(startStringBuilder.toString(), end, bank, visited, memo);
                        if (result > -1) {
                            if (min == -1) {
                                min = 1 + result;
                            }
                            else {
                                min = Math.min(min, 1 + result);
                            }
                        }
                    }
                    startStringBuilder.replace(i, i + 1, String.valueOf(current));
                }
            }
        }
        visited.remove(start);
        memo.put(start, min);
        return min;
    }

}
