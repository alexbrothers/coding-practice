package leetcode.linkedin;

import java.util.*;

public class WordLadder {

    class Graph {
        Map<String, GraphNode> nodes = new HashMap<>();

        public Graph(List<String> wordList, Map<String, Set<String>> maskedStrings) {
            for (int i = 0; i < wordList.size(); i++) {
                String word = wordList.get(i);
                for (int j = 0; j < word.length(); j++) {
                    StringBuilder stringBuilder = new StringBuilder(word);
                    stringBuilder.replace(j, j + 1, "*");
                    if (maskedStrings.containsKey(stringBuilder.toString())) {
                        Set<String> edges = maskedStrings.get(stringBuilder.toString());
                        for (String s : edges) {
                            this.addEdge(word, s);
                        }
                    }
                }
            }
        }

        public void addNode(GraphNode node) {
            if (nodes.containsKey(node.name)) {
                return;
            }
            this.nodes.put(node.name, node);
        }

        public void addEdge(GraphNode node1, GraphNode node2) {
            node1.edges.put(node2.name, node2);
            node2.edges.put(node1.name, node1);
        }

        public void addEdge(String node1, String node2) {
            if (!this.nodes.containsKey(node1)) {
                this.nodes.put(node1, new GraphNode(node1));
            }
            if (!this.nodes.containsKey(node2)) {
                this.nodes.put(node2, new GraphNode(node2));
            }
            addEdge(nodes.get(node1), nodes.get(node2));
        }
    }

    class GraphNode {
        String name;
        Map<String, GraphNode> edges;

        public GraphNode(String name) {
            this.name = name;
            this.edges = new HashMap<>();
        }

    }

    class GraphNodeLevel {
        GraphNode graphNode;
        int level;

        public GraphNodeLevel(GraphNode graphNode, int level) {
            this.graphNode = graphNode;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            throw new IllegalArgumentException();
        }
        Map<String, Set<String>> comboMap = createComboMap(wordList);
        Set<GraphNode> visited = new HashSet<>();
        Graph graph = new Graph(wordList, comboMap);
        Queue<GraphNodeLevel> queue = new LinkedList<>();
        if (graph.nodes.containsKey(beginWord)) {
            queue.add(new GraphNodeLevel(graph.nodes.get(beginWord), 0));
        }
        else {
            for (int i = 0; i < beginWord.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(beginWord);
                stringBuilder.replace(i, i + 1, "*");
                if (comboMap.containsKey(stringBuilder.toString())) {
                    Set<String> start = comboMap.get(stringBuilder.toString());
                    for (String s : start) {
                        queue.add(new GraphNodeLevel(graph.nodes.get(s), 1));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            GraphNodeLevel current = queue.poll();
            if (current.graphNode.name.equals(endWord)) {
                return current.level + 1;
            }
            visited.add(current.graphNode);
            Map<String, GraphNode> edges = current.graphNode.edges;
            for (Map.Entry<String, GraphNode> entry : edges.entrySet()) {
                if (!visited.contains(entry.getValue())) {
                    queue.add(new GraphNodeLevel(entry.getValue(), current.level + 1));
                }
            }
        }
        return 0;
    }

    private Map<String, Set<String>> createComboMap(List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.replace(j, j + 1, "*");
                Set<String> possibilities;
                if (map.containsKey(stringBuilder.toString())) {
                    possibilities = map.get(stringBuilder.toString());
                }
                else {
                    possibilities = new HashSet<>();
                }
                possibilities.add(word);
                map.put(stringBuilder.toString(), possibilities);
            }
        }
        return map;
    }

}
