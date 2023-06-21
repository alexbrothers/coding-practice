package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

    private static final char END_SYMBOL = '*';

    class TrieNode {
        int endWordIndex;
        Map<Character, TrieNode> children = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException();
        }
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], i, words[i].length() - 1, root);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            matches(words[i], i, 0, root, result);
        }
        return result;
    }

    private void matches(String word, int wordIndex, int index, TrieNode node, List<List<Integer>> result) {
        if (index == word.length()) {
            if (node.children.containsKey(END_SYMBOL) && node.children.get(END_SYMBOL).endWordIndex != wordIndex) {
                result.add(List.of(wordIndex, node.children.get(END_SYMBOL).endWordIndex));
            }
            for (int i = 0; i < node.remaining.size(); i++) {
                int current = node.remaining.get(i);
                if (current == wordIndex) {
                    continue;
                }
                result.add(List.of(wordIndex, current));
            }
            return;
        }
        if (node.children.containsKey(END_SYMBOL)) {
            if (isPalindrome(word, index)) {
                result.add(List.of(wordIndex, node.children.get(END_SYMBOL).endWordIndex));
            }
        }
        char current = word.charAt(index);
        if (!node.children.containsKey(current)) {
            return;
        }
        matches(word, wordIndex, index + 1, node.children.get(current), result);
    }

    private boolean isPalindrome(String word, int start) {
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindromeFromEnd(String word, int end) {
        int start = 0;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void addWord(String word, int wordIndex, int index, TrieNode node) {
        if (index < 0) {
            TrieNode end = new TrieNode();
            end.endWordIndex = wordIndex;
            node.children.put(END_SYMBOL, end);
            return;
        }
        if (isPalindromeFromEnd(word, index)) {
            node.remaining.add(wordIndex);
        }
        char current = word.charAt(index);
        node.children.putIfAbsent(current, new TrieNode());
        addWord(word, wordIndex, index - 1, node.children.get(current));
    }

}
