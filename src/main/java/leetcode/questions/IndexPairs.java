package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexPairs {

    private static final char END_SYMBOL = '*';

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public int[][] indexPairs(String text, String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], 0);
        }
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            List<int[]> currentList = new ArrayList<>();
            findWords(text, i, i, root, currentList);
            resultList.addAll(currentList);
        }
        int[][] result = new int[resultList.size()][];
        resultList.toArray(result);
        return result;
    }

    private void findWords(String text, int startIndex, int index, TrieNode node, List<int[]> result) {
        if (node.children.containsKey(END_SYMBOL)) {
            result.add(new int[]{startIndex, index - 1});
        }
        if (index == text.length()) {
            return;
        }
        char current = text.charAt(index);
        if (node.children.containsKey(current)) {
            findWords(text, startIndex, index + 1, node.children.get(current), result);
        }
    }

    private void addWord(TrieNode node, String word, int index) {
        if (index == word.length()) {
            node.children.put(END_SYMBOL, null);
            return;
        }
        char current = word.charAt(index);
        node.children.putIfAbsent(current, new TrieNode());
        addWord(node.children.get(current), word, index + 1);
    }

}
