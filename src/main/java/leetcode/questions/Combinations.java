package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1 || k > n) {
            throw new IllegalArgumentException();
        }
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void combine(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            current.add(i);
            combine(i + 1, n, k - 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}
