package leetcode.questions;

public class MinCostToConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            throw new IllegalArgumentException();
        }
        int edgesConnected = 0;
        boolean[] connected = new boolean[points.length];
        int cost = 0;
        int[] costs = new int[points.length];
        costs[0] = 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i] = Integer.MAX_VALUE;
        }
        int currentEdge = 0;
        int currentEdgeCost = 0;
        while (edgesConnected < points.length) {
            edgesConnected++;
            connected[currentEdge] = true;
            cost += currentEdgeCost;
            int nextEdge = -1;
            int nextEdgeCost = Integer.MAX_VALUE;
            for (int i = 0; i < points.length; i++) {
                if (connected[i]) {
                    continue;
                }
                int distance = getDistance(points, currentEdge, i);
                costs[i] = Math.min(costs[i], distance);
                if (costs[i] < nextEdgeCost) {
                    nextEdge = i;
                    nextEdgeCost = costs[i];
                }
            }
            currentEdge = nextEdge;
            currentEdgeCost = nextEdgeCost;
        }
        return cost;
    }

    private int getDistance(int points[][], int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }

}
