package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOriginalArray {

    public int[] findOriginalArray(int[] changed) {
        if (changed == null || changed.length == 0) {
            throw new IllegalArgumentException();
        }
        if (changed.length % 2 != 0) {
            return new int[]{};
        }
        countSort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        int[] result = new int[changed.length / 2];
        int resultIndex = 0;
        for (int i = 0; i < changed.length && resultIndex < result.length; i++) {
            int num = changed[i];
            if (!map.containsKey(num)) {
                continue;
            }
            if (map.get(num) == 1) {
                map.remove(num);
            }
            else {
                map.put(num, map.get(num) - 1);
            }
            if (!map.containsKey(num * 2)) {
                return new int[]{};
            }
            if (map.get(num * 2) == 1) {
                map.remove(num * 2);
            }
            else {
                map.put(num * 2, map.get(num * 2) - 1);
            }
            result[resultIndex] = num;
            resultIndex++;
        }
        return result;
    }

    private void countSort(int[] array) {
        int[] counts = new int[100001];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                array[index] = i;
                counts[i]--;
                index++;
            }
        }
    }

}
