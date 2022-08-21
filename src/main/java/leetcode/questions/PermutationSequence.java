package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * (i + 1);
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        int numOffset = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (nums.size() > 1) {
            int index = k / factorials[n - numOffset - 1];
            int sequencesPassed = index * factorials[n - numOffset - 1];
            stringBuilder.append(nums.remove(index));
            k -= sequencesPassed;
            numOffset++;
        }
        stringBuilder.append(nums.get(0));
        return stringBuilder.toString();
    }

}
