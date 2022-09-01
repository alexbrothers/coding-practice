package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class WaterFlow {

    private static final int[][] directions = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};

    class WaterFlowHelper {
        boolean pacific;
        boolean atlantic;

        WaterFlowHelper(boolean pacific, boolean atlantic) {
            this.pacific = pacific;
            this.atlantic = atlantic;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        WaterFlowHelper[][] board = new WaterFlowHelper[heights.length][heights[0].length];
        for (int row = heights.length - 1; row >= 0; row--) {
            waterFlow(heights, row, 0, board, true, result);
        }
        for (int col = 1; col < heights[0].length; col++) {
            waterFlow(heights, 0, col, board, true, result);
        }
        for (int col = 0; col < heights[0].length; col++) {
            waterFlow(heights, heights.length - 1, col, board, false, result);
        }
        for (int row = heights.length - 2; row >= 0; row--) {
            waterFlow(heights, row, heights[0].length - 1, board, false, result);
        }
        return result;
    }

    private void waterFlow(int[][] heights, int row, int col, WaterFlowHelper[][] board, boolean pacific, List<List<Integer>> result) {
        WaterFlowHelper current;
        if (board[row][col] == null) {
            current = new WaterFlowHelper(pacific, !pacific);
        }
        else {
            current = board[row][col];
            if (pacific) {
                if (current.pacific) {
                    return;
                }
                current.pacific = true;
            }
            else {
                if (current.atlantic) {
                    return;
                }
                current.atlantic = true;
            }
        }
        board[row][col] = current;
        if (current.pacific && current.atlantic) {
            result.add(List.of(row, col));
        }
        for (int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length && heights[row][col] <= heights[newRow][newCol]) {
                waterFlow(heights, newRow, newCol, board, pacific, result);
            }
        }
    }

}
