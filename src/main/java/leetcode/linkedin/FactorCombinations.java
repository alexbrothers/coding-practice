package leetcode.linkedin;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        getFactors(n, 2, new ArrayList<>(), result);
        return result;
    }

    private void getFactors(int num, int factor, List<Integer> current, List<List<Integer>> result) {
        if (current.size() >= 1) {
            current.add(num);
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
        for (int i = factor; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                current.add(i);
                getFactors(num / i, i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

}
