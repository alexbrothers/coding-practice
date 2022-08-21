package leetcode.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(".");
        }
        for (int i = 0; i < n; i++) {
            board.add(stringBuilder.toString());
        }
        List<List<String>> result = new ArrayList<>();
        solveNQueens(n, 0, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(), board, result);
        return result;
    }

    private void solveNQueens(
            int n,
            int row,
            int queensPlaced,
            Set<Integer> rowsUsed,
            Set<Integer> columnsUsed,
            Set<Integer> diagonal1Used,
            Set<Integer> diagonal2Used,
            List<String> board,
            List<List<String>> result
    ) {
        if (queensPlaced == n) {
            result.add(new ArrayList<>(board));
            return;
        }
        if (row == n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canPlace(row, i, rowsUsed, columnsUsed, diagonal1Used, diagonal2Used)) {
                rowsUsed.add(row);
                columnsUsed.add(i);
                diagonal1Used.add(row - i);
                diagonal2Used.add(row + i);
                StringBuilder stringBuilder = new StringBuilder(board.get(row));
                stringBuilder.replace(i, i + 1, "Q");
                board.set(row, stringBuilder.toString());
                solveNQueens(n, row + 1, queensPlaced + 1, rowsUsed, columnsUsed, diagonal1Used, diagonal2Used, board, result);
                stringBuilder.replace(i, i + 1, ".");
                board.set(row, stringBuilder.toString());
                rowsUsed.remove(row);
                columnsUsed.remove(i);
                diagonal1Used.remove(row - i);
                diagonal2Used.remove(row + i);
            }
        }
    }

    private boolean canPlace(int row, int col, Set<Integer> rowsUsed, Set<Integer> columnsUsed, Set<Integer> diagonal1Used, Set<Integer> diagonal2Used) {
        return !rowsUsed.contains(row) &&
                !columnsUsed.contains(col) &&
                !diagonal1Used.contains(row - col) &&
                !diagonal2Used.contains(row + col);
    }

}
