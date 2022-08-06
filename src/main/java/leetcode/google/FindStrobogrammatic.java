package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindStrobogrammatic {

    public List<String> findStrobogrammatic(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        List<String> result = new ArrayList<>();
        findStrobogrammatic(0, new char[n], result, map);
        return result;
    }

    private void findStrobogrammatic(int offset, char[] current, List<String> result, Map<Character, Character> map) {
        if ((current.length % 2 == 0 && offset >= current.length / 2) || (current.length % 2 != 0 && offset > current.length / 2)) {
            result.add(new String(current));
            return;
        }
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            if ((entry.getKey() != entry.getValue() && offset == current.length - offset - 1) || (current.length > 1 && offset == 0 && entry.getKey() == '0')) {
                continue;
            }
            current[offset] = entry.getKey();
            current[current.length - offset - 1] = entry.getValue();
            findStrobogrammatic(offset + 1, current, result, map);
        }
    }

}
