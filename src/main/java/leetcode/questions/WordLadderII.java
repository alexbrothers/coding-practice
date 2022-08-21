package leetcode.questions;

import java.util.*;

public class WordLadderII {

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char original = wordArray[i];
            for (int j = 0; j <= 26; j++) {
                char newChar = (char) (j + 'a');
                if (original == newChar) {
                    continue;
                }
                wordArray[i] = newChar;
                String candidate = new String(wordArray);
                if (wordSet.contains(candidate)) {
                    neighbors.add(candidate);
                }
            }
            wordArray[i] = original;
        }
        return neighbors;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            throw new IllegalArgumentException();
        }
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, List<String>> graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Set<String> enqueued = new HashSet<>();
            for (int i = queue.size(); i > 0; i--) {
                String word = queue.poll();
                visited.add(word);
                List<String> neighbors = getNeighbors(word, wordSet);
                for (int j = 0; j < neighbors.size(); j++) {
                    String neighbor = neighbors.get(j);
                    if (!visited.contains(neighbor)) {
                        if (!graph.containsKey(neighbor)) {
                            graph.put(neighbor, new ArrayList<>());
                        }
                        graph.get(neighbor).add(word);
                        if (!enqueued.contains(neighbor)) {
                            queue.add(neighbor);
                            enqueued.add(neighbor);
                        }
                    }
                }
            }
            for (String word : enqueued) {
                visited.add(word);
            }
        }
        dfs(endWord, beginWord, new ArrayList<>(), result, new HashSet<>(), graph);
        return result;
    }

    private void dfs(String word, String endWord, List<String> words, List<List<String>> result, Set<String> visited, Map<String, List<String>> graph) {
        if (visited.contains(word)) {
            return;
        }
        if (word.equals(endWord)) {
            List<String> temp = new ArrayList<>(words);
            temp.add(endWord);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }
        visited.add(word);
        words.add(word);
        List<String> edges = graph.get(word);
        if (edges != null) {
            for (int i = 0; i < edges.size(); i++) {
                dfs(edges.get(i), endWord, words, result, visited, graph);
            }
        }
        words.remove(words.size() - 1);
        visited.remove(word);
    }

}
