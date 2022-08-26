package leetcode.questions;

import java.util.*;

public class MinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null) {
            throw new IllegalArgumentException();
        }
        List<Integer> result = new ArrayList<>();
        if (n < 3) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
                queue.add(i);
            }
        }
        int nodesRemaining = n;
        while (!queue.isEmpty() && nodesRemaining > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int edge : graph.get(node)) {
                    graph.get(edge).remove(node);
                    if (graph.get(edge).size() == 1) {
                        queue.add(edge);
                    }
                }
                nodesRemaining--;
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

}
