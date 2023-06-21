package leetcode.questions;

public class LonelyPixel {

    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] rows = new int[picture.length];
        int[] cols = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

}
