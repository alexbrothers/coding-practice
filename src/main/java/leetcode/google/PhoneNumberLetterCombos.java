package leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombos {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        findCombos(digits, 0, new StringBuilder(), result, createPhoneNumberMap());
        return result;
    }

    private Map<Character, List<Character>> createPhoneNumberMap() {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        return map;
    }

    private void findCombos(String phoneNumber, int index, StringBuilder current, List<String> result, Map<Character, List<Character>> phoneNumberMap) {
        if (index == phoneNumber.length()) {
            result.add(current.toString());
            return;
        }
        List<Character> candidates = phoneNumberMap.get(phoneNumber.charAt(index));
        for (int i = 0; i < candidates.size(); i++) {
            current.append(candidates.get(i));
            findCombos(phoneNumber, index + 1, current, result, phoneNumberMap);
            current.deleteCharAt(current.length() - 1);
        }
    }

}
