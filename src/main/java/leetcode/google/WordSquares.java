package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquares {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<String> words = new ArrayList<>();
    }

    private void addWord(TrieNode node, String str, int index) {
        if (index == str.length()) {
            return;
        }
        node.words.add(str);
        Character current = str.charAt(index);
        if (!node.children.containsKey(current)) {
            node.children.put(current, new TrieNode());
        }
        addWord(node.children.get(current), str, index + 1);
    }

    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        int wordLength = words[0].length();
        List<List<String>> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], 0);
        }
        wordSquares(0, wordLength, root, "", new ArrayList<>(), result);
        return result;
    }

    private List<String> getCandidatesWithPrefix(TrieNode node, String prefix, int index) {
        if (index == prefix.length()) {
            return node.words;
        }
        char current = prefix.charAt(index);
        if (!node.children.containsKey(current)) {
            return null;
        }
        return getCandidatesWithPrefix(node.children.get(current), prefix, index + 1);
    }

    private void wordSquares(int index, int wordLength, TrieNode root, String prefix, List<String> currentWords, List<List<String>> result) {
        List<String> candidates = getCandidatesWithPrefix(root, prefix, 0);
        if (candidates == null) {
            return;
        }
        for (int i = 0; i < candidates.size(); i++) {
            String candidate = candidates.get(i);
            currentWords.add(candidate);
            if (currentWords.size() == wordLength) {
                result.add(new ArrayList<>(currentWords));
            }
            else {
                wordSquares(index + 1, wordLength, root, buildPrefix(currentWords, index), currentWords, result);
            }
            currentWords.remove(currentWords.size() - 1);
        }
    }

    private String buildPrefix(List<String> currentWords, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < index + 1; i++) {
            stringBuilder.append(currentWords.get(i).charAt(index + 1));
        }
        return stringBuilder.toString();
    }

}
