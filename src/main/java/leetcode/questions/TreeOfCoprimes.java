package leetcode.questions;

import java.util.*;

public class TreeOfCoprimes {

    class GraphNode {
        int index;
        int value;
        List<GraphNode> edges;

        GraphNode(int index, int value, List<GraphNode> edges) {
            this.index = index;
            this.value = value;
            this.edges = edges;
        }
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        if (nums == null || edges == null) {
            throw new IllegalArgumentException();
        }
        Map<Integer, GraphNode> graph = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            GraphNode graphNode = new GraphNode(i, nums[i], new ArrayList<>());
            graph.put(i, graphNode);
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            GraphNode child = graph.get(edge[1]);
            GraphNode parent = graph.get(edge[0]);
            child.edges.add(parent);
            parent.edges.add(child);
        }
        int[] result = new int[nums.length];
        Integer[][] memo = new Integer[nums.length][51];
        Arrays.fill(result, -1);
        for (int i = 1; i < nums.length; i++) {
            GraphNode graphNode = graph.get(i);
            dfs(graphNode, graphNode.value, graphNode.index, result, new boolean[nums.length], memo);
        }
        return result;
    }

    private boolean dfs(GraphNode node, int startNum, int startIndex, int[] result, boolean[] visited, Integer[][] memo) {
        if (node.index == 0) {
            return true;
        }
        if (visited[node.index]) {
            return false;
        }
        if (memo[node.index][startNum] != null) {
            result[startIndex] = memo[node.index][startNum];
            return true;
        }
        visited[node.index] = true;
        boolean leadsToRoot = false;
        for (int i = 0; i < node.edges.size(); i++) {
            GraphNode current = node.edges.get(i);
            if (dfs(current, startNum, startIndex, result, visited, memo)) {
                leadsToRoot = true;
                if (gcd(current.value, startNum) == 1) {
                    memo[node.index][startNum] = current.index;
                    result[startIndex] = current.index;
                }
                break;
            }
        }
        visited[node.index] = false;
        return leadsToRoot;
    }

    private int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

}
