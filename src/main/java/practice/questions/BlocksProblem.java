package practice.questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlocksProblem {

    public boolean canFormWord(List<List<Character>> blocks, String word) {
        if (blocks.size() < word.length()) {
            return false;
        }
        char[] wordChars = word.toCharArray();
        Map<Character, Integer> letterCount = new HashMap<>();
        for (int i = 0; i < wordChars.length; i++) {
            letterCount.put(wordChars[i], letterCount.getOrDefault(wordChars[i], 0) + 1);
        }
        return canFormWordHelper(blocks, 0, letterCount, word.length());
    }

    private boolean canFormWordHelper(List<List<Character>> blocks, int index, Map<Character, Integer> letterCount, int lettersNeeded) {
        if (letterCount.isEmpty()) {
            return true;
        }
        if (index >= blocks.size()) {
            return false;
        }
        List<Character> currentLetters = blocks.get(index);
        for (int i = 0; i < currentLetters.size(); i++) {
            Character currentLetter = currentLetters.get(i);
            if (letterCount.containsKey(currentLetter)) {
                int currentLetterCount = letterCount.get(currentLetter);
                if (currentLetterCount - 1 == 0) {
                    letterCount.remove(currentLetter);
                }
                else {
                    letterCount.put(currentLetter, currentLetterCount - 1);
                }
                if (canFormWordHelper(blocks, index + 1, letterCount, lettersNeeded - 1)) {
                    return true;
                }
                letterCount.put(currentLetter, currentLetterCount);
            }
        }
        if (blocks.size() - index > lettersNeeded) {
            if (canFormWordHelper(blocks, index + 1, letterCount, lettersNeeded)) {
                return true;
            }
        }
        return false;
    }

}
