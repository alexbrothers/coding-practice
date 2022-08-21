package leetcode.questions;

public class LargestPalindromicInteger {

    public String largestPalindromic(String num) {
        if (num == null) {
            throw new IllegalArgumentException();
        }
        int[] counts = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int current = num.charAt(i) - '0';
            counts[current]++;
        }
        StringBuilder result = new StringBuilder();
        int maxOddIndex = -1;
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] == 0 || (i == 0 && result.length() < 2)) {
                continue;
            }
            if (counts[i] % 2 != 0) {
                if (counts[i] > 1) {
                    insertMiddle(result, (char) (i + '0'), counts[i] - 1);
                    counts[i] = 1;
                }
                if (maxOddIndex == -1) {
                    maxOddIndex = i;
                }
            }
            else {
                insertMiddle(result, (char) (i + '0'), counts[i]);
            }
        }
        if (maxOddIndex != -1) {
            insertMiddle(result, (char) (maxOddIndex + '0'), 1);
        }
        return result.length() > 0 ? result.toString() : "0";
    }

    private void insertMiddle(StringBuilder stringBuilder, char insert, int times) {
        for (int i = 0; i < times; i++) {
            stringBuilder.insert(stringBuilder.length() / 2, insert);
        }
    }

}
