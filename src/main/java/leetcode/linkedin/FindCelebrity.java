package leetcode.linkedin;

import java.util.Arrays;

public class FindCelebrity {

    public int[][] graph;

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        return isCelebrity(candidate, n) ? candidate : -1;
    }

    private boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (j == i) {
                continue;
            }
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean knows(int i, int j) {
        return graph[i][j] == 1;
    }

}
