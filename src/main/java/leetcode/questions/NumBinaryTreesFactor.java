package leetcode.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumBinaryTreesFactor {

    private static final int MOD = ((int) Math.pow(10, 9) + 7);

    public int numFactoredBinaryTrees(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        int[] memo = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            result = (num(arr, i, map, memo) + result) % MOD;
        }
        return result;
    }

    private int num(int[] arr, int index, Map<Integer, Integer> nums, int[] memo) {
        if (memo[index] != 0) {
            return memo[index];
        }
        int root = arr[index];
        long result = 1;
        for (int i = 0; i < arr.length; i++) {
            if (root % arr[i] == 0 && nums.containsKey(root / arr[i])) {
                long left = num(arr, i, nums, memo);
                long right = num(arr, nums.get(root / arr[i]), nums, memo);
                result = ((left * right) + result) % MOD;
            }
        }
        memo[index] = (int) result;
        return (int) result;
    }

}
