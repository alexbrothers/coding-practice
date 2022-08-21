package leetcode.questions;

public class MinimumRecolors {

    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        int edits = 0;
        int left = 0;
        int right = 0;
        int minEdits = Integer.MAX_VALUE;
        while (right < blocks.length()) {
            char current = blocks.charAt(right);
            count++;
            if (current == 'W') {
                edits++;
            }
            if (count == k) {
                minEdits = Math.min(minEdits, edits);
                if (minEdits == 0) {
                    break;
                }
                while (blocks.charAt(left) == 'B') {
                    count--;
                    left++;
                }
                edits--;
                count--;
                left++;
            }
            right++;
        }
        if (count == k) {
            minEdits = Math.min(minEdits, edits);
        }
        return minEdits;
    }

}
