package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithDifferences {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        numsHelper(n, k, 0, null, result);
        int[] returned = new int[result.size()];
        for (int i = 0; i < returned.length; i++) {
            returned[i] = result.get(i);
        }
        return returned;
    }

    private void numsHelper(int n, int k, int currentNum, Integer lastDigit, List<Integer> result) {
        if (n == 0) {
            result.add(currentNum);
            return;
        }
        if (lastDigit == null) {
            for (int i = 1; i <= 9; i++) {
                numsHelper(n - 1, k, i, i, result);
            }
        }
        else {
            if (k == 0) {
                int next = (currentNum * 10) + (lastDigit);
                numsHelper(n - 1, k, next, lastDigit, result);
            }
            else {
                if (lastDigit - k >= 0) {
                    int next = (currentNum * 10) + (lastDigit - k);
                    numsHelper(n - 1, k, next, lastDigit - k, result);
                }
                if (lastDigit + k <= 9) {
                    int next = (currentNum * 10) + (lastDigit + k);
                    numsHelper(n - 1, k, next, lastDigit + k, result);
                }
            }
        }
    }

}
