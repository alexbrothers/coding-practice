package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], new String[]{sources[i], targets[i]});
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (map.containsKey(index)) {
                String[] operations = map.get(index);
                String source = operations[0];
                String target = operations[1];
                if (s.startsWith(source, index)) {
                    stringBuilder.append(target);
                    index += source.length();
                }
                else {
                    stringBuilder.append(s.charAt(index));
                    index++;
                }
            }
            else {
                stringBuilder.append(s.charAt(index));
                index++;
            }
        }
        return stringBuilder.toString();
    }

}
