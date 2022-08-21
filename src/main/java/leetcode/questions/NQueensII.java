package leetcode.questions;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {

    public int totalNQueens(int n) {
        return nQueens(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int nQueens(int n, int row, Set<Integer> rowsUsed, Set<Integer> columnsUsed, Set<Integer> diagonals1Used, Set<Integer> diagonals2Used) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (canPlace(row, i, rowsUsed, columnsUsed, diagonals1Used, diagonals2Used)) {
                rowsUsed.add(row);
                columnsUsed.add(i);
                diagonals1Used.add(row - i);
                diagonals2Used.add(row + i);
                count += nQueens(n, row + 1,  rowsUsed, columnsUsed, diagonals1Used, diagonals2Used);
                rowsUsed.remove(row);
                columnsUsed.remove(i);
                diagonals1Used.remove(row - i);
                diagonals2Used.remove(row + i);
            }
        }
        return count;
    }

    private boolean canPlace(int row, int col, Set<Integer> rowsUsed, Set<Integer> columnsUsed, Set<Integer> diagonals1Used, Set<Integer> diagonals2Used) {
        return !rowsUsed.contains(row) &&
                !columnsUsed.contains(col) &&
                !diagonals1Used.contains(row - col) &&
                !diagonals2Used.contains(row + col);
    }

}
