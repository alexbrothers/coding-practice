package leetcode.google;

public class DecodeString {

    class IndexWrapper {
        int index;
    }

    public String decodeString(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        return decode(s, new IndexWrapper());
    }

    private String decode(String s, IndexWrapper indexWrapper) {
        StringBuilder stringBuilder = new StringBuilder();
        while (indexWrapper.index < s.length()) {
            char current = s.charAt(indexWrapper.index);
            if (current == ']') {
                indexWrapper.index++;
                break;
            }
            if (current == '[') {
                indexWrapper.index++;
                continue;
            }
            if (Character.isDigit(current)) {
                int times = getNumberOfTimes(s, indexWrapper);
                String result = decode(s, indexWrapper);
                for (int i = 0; i < times; i++) {
                    stringBuilder.append(result);
                }
            }
            else {
                indexWrapper.index++;
                stringBuilder.append(current);
            }
        }
        return stringBuilder.toString();
    }

    private int getNumberOfTimes(String s, IndexWrapper indexWrapper) {
        int multiplier = 10;
        int result = 0;
        while (true) {
            char current = s.charAt(indexWrapper.index);
            if (Character.isDigit(current)) {
                indexWrapper.index++;
                result = (result * multiplier) + (current - '0');
            }
            else {
                break;
            }
        }
        return result;
    }

}
