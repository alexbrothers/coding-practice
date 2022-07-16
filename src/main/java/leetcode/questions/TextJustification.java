package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        List<String> currentWords = new ArrayList<>();
        int currentLineLength = 0;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (currentWord.length() > maxWidth) {
                throw new IllegalArgumentException("Word itself is greater than max width");
            }
            if (currentLineLength + currentWords.size() + currentWord.length() <= maxWidth) {
                currentWords.add(currentWord);
                currentLineLength += currentWord.length();
            }
            else {
                createJustifiedString(currentWords, maxWidth, result, false);
                currentWords = new ArrayList<>();
                currentLineLength = 0;
                i--;
            }
        }
        if (currentWords.size() != 0) {
            createJustifiedString(currentWords, maxWidth, result, true);
        }
        return result;
    }

    private void createJustifiedString(List<String> words, int maxWidth, List<String> result, boolean lastLine) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> endOfWordIndexes = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            stringBuilder.append(words.get(i));
            if (i != words.size() - 1) {
                stringBuilder.append(' ');
                endOfWordIndexes.add(stringBuilder.length());
            }
        }
        if (lastLine || words.size() == 1) {
            while (stringBuilder.length() < maxWidth) {
                stringBuilder.append(" ");
            }
        }
        else {
            int diff = maxWidth - stringBuilder.length();
            int wordIndex = 0;
            int loops = 1;
            while (diff > 0) {
                stringBuilder.insert(endOfWordIndexes.get(wordIndex) + (wordIndex * loops), " ");
                diff--;
                wordIndex++;
                if (wordIndex >= endOfWordIndexes.size()) {
                    wordIndex = wordIndex % endOfWordIndexes.size();
                    loops++;
                }
            }
        }
        result.add(stringBuilder.toString());
    }

}
