package leetcode.google;

public class RemoveStones {

    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] parent = new int[stones.length];
        for (int i = 0; i < stones.length; i++) {
            parent[i] = i;
        }
        int result = 0;
        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                int[] iStone = stones[i];
                int[] jStone = stones[j];
                if (iStone[0] == jStone[0] || iStone[1] == jStone[1]) {
                    if (union(i, j, parent)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private int find(int[] parent, int index) {
        if (parent[index] == index) {
            return index;
        }
        return find(parent, parent[index]);
    }

    private boolean union(int x, int y, int[] parent) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        if (parentX == parentY) {
            return false;
        }
        parent[parentX] = parentY;
        return true;
    }

}
