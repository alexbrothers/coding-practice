package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {

    public List<String> printVertically(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        String[] split = s.split(" ");
        int maxLength = 0;
        for (int i = 0; i < split.length; i++) {
            maxLength = Math.max(maxLength, split[i].length());
        }
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < maxLength) {
            StringBuilder stringBuilder = new StringBuilder();
            int spaces = 0;
            for (int i = 0; i < split.length; i++) {
                if (index < split[i].length()) {
                    for (int j = 0; j < spaces; j++) {
                        stringBuilder.append(' ');
                    }
                    stringBuilder.append(split[i].charAt(index));
                    spaces = 0;
                }
                else {
                    spaces++;
                }
            }
            result.add(stringBuilder.toString());
            index++;
        }
        return result;
    }

}
