package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int index = 0;
        int result = 0;
        while (index < s.length()) {
            int first = map.get(s.charAt(index));
            int next = index + 1 < s.length() ? map.get(s.charAt(index + 1)) : Integer.MIN_VALUE;
            if (first < next) {
                result += next - first;
                index += 2;
            }
            else {
                result += first;
                index++;
            }
        }
        return result;
    }

}
