package leetcode.questions;

public class StringToInteger {

    public int myAtoi(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        s = s.trim();
        boolean negative = false;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (i == 0 && current == '+') {
                continue;
            }
            if (i == 0 && current == '-') {
                negative = true;
                continue;
            }
            if (!Character.isDigit(current)) {
                break;
            }
            int digit = current - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result * 10) + digit;
        }
        return negative ? result * -1 : result;
    }

}
