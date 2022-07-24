package leetcode.google;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num1.length() + num2.length(); i++) {
            result.append("0");
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            int digit2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int digit1 = num1.charAt(j) - '0';
                int next = (digit2 * digit1) + carry;
                if (next >= 10) {
                    carry = next / 10;
                    next = next % 10;
                }
                else {
                    carry = 0;
                }
                addNextDigit(result, i + j + 1, next);
                if (j == 0 && carry != 0) {
                    addNextDigit(result, i + j, carry);
                }
            }
        }
        while (true) {
            if (result.charAt(0) == '0') {
                result.deleteCharAt(0);
            }
            else {
                break;
            }
        }
        return result.toString();
    }

    private void addNextDigit(StringBuilder result, int index, int digit) {
        while (true) {
            int current = result.charAt(index) - '0';
            current += digit;
            if (current >= 10) {
                digit = current / 10;
                current = current % 10;
                result.replace(index, index + 1, "" + current);
            }
            else {
                result.replace(index, index + 1, "" + current);
                break;
            }
            index--;
        }
    }

}
