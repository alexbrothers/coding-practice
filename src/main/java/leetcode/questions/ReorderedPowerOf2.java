package leetcode.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int[] counts = countDigits(n);
        for (int i = 1; i < 30; i++) {
            if (Arrays.equals(counts, countDigits((int) Math.pow(2, i)))) {
                return true;
            }
        }
        return false;
    }

    private int[] countDigits(int n) {
        int[] counts = new int[10];
        while (n > 0) {
            int digit = n % 10;
            counts[digit]++;
            n /= 10;
        }
        return counts;
    }

}
