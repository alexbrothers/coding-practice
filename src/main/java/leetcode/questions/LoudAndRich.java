package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoudAndRich {

    class Graph {
        List<GraphNode> nodes;

        Graph(int[] quiet, int[][] richer) {
            nodes = new ArrayList<>();
            for (int i = 0; i < quiet.length; i++) {
                GraphNode current = new GraphNode(i, quiet[i], new ArrayList<>());
                nodes.add(current);
            }
            for (int i = 0; i < richer.length; i++) {
                int[] current = richer[i];
                GraphNode moreRich = nodes.get(current[0]);
                GraphNode lessRich = nodes.get(current[1]);
                lessRich.parents.add(moreRich);
            }
        }
    }

    class GraphNode {
        int person;
        int quietness;
        List<GraphNode> parents;

        GraphNode(int person, int quietness, List<GraphNode> parents) {
            this.person = person;
            this.quietness = quietness;
            this.parents = parents;
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        if (richer == null || quiet == null) {
            throw new IllegalArgumentException();
        }
        Graph graph = new Graph(quiet, richer);
        Integer[] memo = new Integer[quiet.length];
        int[] result = new int[quiet.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = findQuietest(graph.nodes.get(i), quiet, memo);
        }
        return result;
    }

    private int findQuietest(GraphNode graphNode, int[] quiet, Integer[] memo) {
        if (memo[graphNode.person] != null) {
            return memo[graphNode.person];
        }
        int minPerson = graphNode.person;
        for (int i = 0; i < graphNode.parents.size(); i++) {
            int result = findQuietest(graphNode.parents.get(i), quiet, memo);
            if (quiet[result] < quiet[minPerson]) {
                minPerson = result;
            }
        }
        memo[graphNode.person] = minPerson;
        return minPerson;
    }

}
