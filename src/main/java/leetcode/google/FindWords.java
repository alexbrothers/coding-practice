package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWords {

    private static final char END_SYMBOL = '*';

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], 0, root);
        }
        return root;
    }

    private void removeWord(String word, int index, TrieNode node) {
        if (index == word.length()) {
            node.children.remove(END_SYMBOL);
            return;
        }
        char current = word.charAt(index);
        removeWord(word, index + 1, node.children.get(current));
        if (node.children.get(current).children.isEmpty()) {
            node.children.remove(current);
        }
    }

    private void addWord(String word, int index, TrieNode node) {
        if (index == word.length()) {
            TrieNode end = new TrieNode();
            end.word = word;
            node.children.put(END_SYMBOL, end);
            return;
        }
        char current = word.charAt(index);
        if (!node.children.containsKey(current)) {
            node.children.put(current, new TrieNode());
        }
        addWord(word, index + 1, node.children.get(current));
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (root.children.containsKey(current)) {
                    findWords(board, i, j, root.children.get(current), new boolean[board.length][board[0].length], result, root);
                }
            }
        }
        return result;
    }

    private void findWords(char[][] board, int row, int col, TrieNode node, boolean[][] visited, List<String> result, TrieNode root) {
        if (node.children.containsKey(END_SYMBOL)) {
            String word = node.children.get(END_SYMBOL).word;
            result.add(word);
            removeWord(word, 0, root);
        }
        visited[row][col] = true;
        if (row - 1 >= 0 && !visited[row - 1][col] && node.children.containsKey(board[row - 1][col])) {
            findWords(board, row - 1, col, node.children.get(board[row - 1][col]), visited, result, root);
        }
        if (row + 1 < board.length && !visited[row + 1][col] && node.children.containsKey(board[row + 1][col])) {
            findWords(board, row + 1, col, node.children.get(board[row + 1][col]), visited, result, root);
        }
        if (col - 1 >= 0 && !visited[row][col - 1] && node.children.containsKey(board[row][col - 1])) {
            findWords(board, row, col - 1, node.children.get(board[row][col - 1]), visited, result, root);
        }
        if (col + 1 < board[0].length && !visited[row][col + 1] && node.children.containsKey(board[row][col + 1])) {
            findWords(board, row, col + 1, node.children.get(board[row][col + 1]), visited, result, root);
        }
        visited[row][col] = false;
    }

}
