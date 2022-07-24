package leetcode.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpressionWords {

    Character end = '*';

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public int expressiveWords(String s, String[] words) {
        if (s == null || words == null) {
            throw new IllegalArgumentException();
        }
        TrieNode root = buildTrie(words);
        return countExpressiveWords(s, 0, root, null);
    }

    private int countExpressiveWords(String s, int index, TrieNode node, Character expressionCharacter) {
        if (index >= s.length()) {
            return node.children.containsKey(end) ? 1 : 0;
        }
        int count = 0;
        Character current = s.charAt(index);
        if (!node.children.containsKey(current)) {
            return 0;
        }
        if (expressionCharacter != null && current != expressionCharacter) {
            expressionCharacter = null;
        }
        if ((expressionCharacter == null || current != expressionCharacter) && isExpressiveCharacter(s, index)) {
            int expressionIndex = index;
            while (expressionIndex < s.length() && current == s.charAt(expressionIndex)) {
                count += countExpressiveWords(s, expressionIndex + 1, node.children.get(current), current);
                expressionIndex++;
            }
        }
        else {
            count += countExpressiveWords(s, index + 1, node.children.get(current), expressionCharacter);
        }
        return count;
    }

    private boolean isExpressiveCharacter(String s, int index) {
        if (index + 2 >= s.length()) {
            return false;
        }
        Character current = s.charAt(index);
        return current == s.charAt(index + 1) && current == s.charAt(index + 2);
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], 0);
        }
        return root;
    }

    private void addWord(TrieNode root, String word, int index) {
        if (index == word.length()) {
            root.children.put(end, null);
            return;
        }
        Character current = word.charAt(index);
        if (!root.children.containsKey(current)) {
            root.children.put(current, new TrieNode());
        }
        addWord(root.children.get(current), word, index + 1);
    }

}
