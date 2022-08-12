package leetcode.questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountVowelPermutations {

    public int countVowelPermutation(int n) {
        Map<Character, List<Character>> options = new HashMap<>();
        options.put('a', List.of('e'));
        options.put('e', List.of('a', 'i'));
        options.put('i', List.of('a', 'e', 'o', 'u'));
        options.put('o', List.of('i', 'u'));
        options.put('u', List.of('a'));
        return getVowelPermutation(null, n, options, new HashMap<>(), ((int) Math.pow(10, 9)) + 7);
    }

    private int getVowelPermutation(Character lastLetter, int n, Map<Character, List<Character>> options, Map<String, Integer> memo, int mod) {
        if (n == 0) {
            return 1;
        }
        int count = 0;
        if (lastLetter == null) {
            for (Map.Entry<Character, List<Character>> entry : options.entrySet()) {
                int nextCount = getVowelPermutation(entry.getKey(), n - 1, options, memo, mod);
                count = (count + nextCount) % mod;
            }
        }
        else {
            String key = lastLetter + "|" + n;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            List<Character> nextCharacter = options.get(lastLetter);
            for (int i = 0; i < nextCharacter.size(); i++) {
                int nextCount = getVowelPermutation(nextCharacter.get(i), n - 1, options, memo, mod);
                count = (count + nextCount) % mod;
            }
            memo.put(key, count % mod);
        }
        return count % mod;
    }

}
