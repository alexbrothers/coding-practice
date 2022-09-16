package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class UTFValidation {

    public boolean validUtf8(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        List<String> converted = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            String binary = Integer.toBinaryString(num);
            int beginning = Math.max(0, binary.length() - 8);
            StringBuilder truncated = new StringBuilder(binary.substring(beginning));
            while (truncated.length() < 8) {
                truncated.insert(0, '0');
            }
            converted.add(truncated.toString());
        }
        int index = 0;
        int currentCharacterLength = 0;
        while (index < converted.size()) {
            String current = converted.get(index);
            if (currentCharacterLength == 0) {
                if (!isValidStart(current)) {
                    return false;
                }
                currentCharacterLength = getNumberOfBytes(current);
            }
            else {
                if (!isValidContinuation(current)) {
                    return false;
                }
            }
            index++;
            currentCharacterLength--;
        }
        return currentCharacterLength == 0;
    }

    private boolean isValidContinuation(String str) {
        return str.charAt(0) == '1' && str.charAt(1) == '0';
    }

    private boolean isValidStart(String str) {
        int count = 0;
        int index = 0;
        while (index < str.length()) {
            if (str.charAt(index) == '0') {
                break;
            }
            count++;
            index++;
        }
        return count != 1 && count < 5;
    }

    private int getNumberOfBytes(String str) {
        int count = 0;
        int index = 0;
        while (index < 4) {
            if (str.charAt(index) == '0') {
                break;
            }
            count++;
            index++;
        }
        return count == 0 ? 1 : count;
    }

}
