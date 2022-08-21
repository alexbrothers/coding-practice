package leetcode.questions;

public class ShiftingLetters {

    public String shiftingLetters(String s, int[][] shifts) {
        if (s == null || shifts == null) {
            throw new IllegalArgumentException();
        }
        int[] prefix = new int[s.length() + 1];
        for (int i = 0; i < shifts.length; i++) {
            int amount = shifts[i][2] == 1 ? 1 : -1;
            prefix[shifts[i][0]] += amount;
            prefix[shifts[i][1] + 1] -= amount;
        }
        char[] word = s.toCharArray();
        int amount = 0;
        for (int i = 0; i < prefix.length - 1; i++) {
            amount += prefix[i];
            shiftChar(word, i, amount);
        }
        return new String(word);
    }

    private void shiftChar(char[] word, int index, int amount) {
        int num = word[index] - 'a';
        num = (num + amount) % 26;
        if (num < 0) {
            num = 26 + num;
        }
        word[index] = (char) (num + 'a');
    }

}
