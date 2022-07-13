package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class PaintHouses {

    Integer[][][] memo = new Integer[100][100][21];

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        if (houses == null || cost == null || houses.length != cost.length) {
            throw new IllegalArgumentException();
        }
        Integer result = minCostHelper(houses, 0, cost, 0, target, -1);
        return result == null ? -1 : result;
    }

    private Integer minCostHelper(int[] houses, int index, int[][] cost, int currentNumNeighborhoods, int target, int prevColor) {
        if (index == houses.length) {
            return currentNumNeighborhoods == target ? 0 : null;
        }
        if (currentNumNeighborhoods > target) {
            return null;
        }
        if (prevColor > 0 && memo[index][currentNumNeighborhoods][prevColor - 1] != null) {
            return memo[index][currentNumNeighborhoods][prevColor - 1];
        }
        int[] costs = cost[index];
        int currentColor = houses[index];
        Integer minCost = null;
        if (currentColor != 0) {
            int newNeighborhoodCount = currentColor == prevColor ? currentNumNeighborhoods : currentNumNeighborhoods + 1;
            minCost = minCostHelper(
                    houses,
                    index + 1,
                    cost,
                    newNeighborhoodCount,
                    target,
                    currentColor
            );
        }
        else {
            for (int i = 0; i < costs.length; i++) {
                int candidateCost = costs[i];
                int newNeighborhoodCount = i + 1 == prevColor ? currentNumNeighborhoods : currentNumNeighborhoods + 1;
                Integer candidateMinCost = minCostHelper(
                        houses,
                        index + 1,
                        cost,
                        newNeighborhoodCount,
                        target,
                        i + 1
                );
                if (candidateMinCost != null) {
                    if (minCost == null) {
                        minCost = candidateMinCost + candidateCost;
                    }
                    else {
                        minCost = Math.min(minCost, candidateCost + candidateMinCost);
                    }
                }
            }
        }
        if (minCost != null && prevColor != -1) {
            memo[index][currentNumNeighborhoods][prevColor - 1] = minCost;
        }
        return minCost;
    }

}
