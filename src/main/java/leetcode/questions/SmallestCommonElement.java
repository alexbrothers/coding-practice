package leetcode.questions;

public class SmallestCommonElement {

    class Helper {
        int max;
        boolean finished;

        Helper(int max, boolean finished) {
            this.max = max;
            this.finished = finished;
        }
    }

    public int smallestCommonElement(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] indexes = new int[mat.length];
        while (true) {
            Helper helper = findMax(mat, indexes);
            if (helper.finished) {
                return helper.max;
            }
            if (!updateIndexes(mat, indexes, helper.max)) {
                return -1;
            }
        }
    }

    private boolean updateIndexes(int[][] mat, int[] indexes, int max) {
        for (int i = 0; i < indexes.length; i++) {
            int currentIndex = indexes[i];
            int[] row = mat[i];
            while (row[currentIndex] < max) {
                if (currentIndex == mat[0].length - 1) {
                    return false;
                }
                currentIndex++;
            }
            indexes[i] = currentIndex;
        }
        return true;
    }

    private Helper findMax(int[][] mat, int[] indexes) {
        int max = mat[0][indexes[0]];
        boolean allSame = true;
        for (int i = 1; i < indexes.length; i++) {
            int value = mat[i][indexes[i]];
            if (value > max) {
                allSame = false;
                max = value;
            }
            else if (value < max) {
                allSame = false;
            }
        }
        return new Helper(max, allSame);
    }

}
