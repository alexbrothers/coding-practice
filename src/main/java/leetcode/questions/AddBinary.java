package leetcode.questions;

public class AddBinary {

    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        while (indexA >= 0 || indexB >= 0) {
            int numA = 0;
            int numB = 0;
            if (indexA >= 0) {
                numA = a.charAt(indexA) - '0';
                indexA--;
            }
            if (indexB >= 0) {
                numB = b.charAt(indexB) - '0';
                indexB--;
            }
            int digit = numA + numB + carry;
            if (digit <= 1) {
                result.append((char) (digit + '0'));
                carry = 0;
            }
            else {
                carry = 1;
                if (digit == 2) {
                    result.append('0');
                }
                else {
                    result.append('1');
                }
            }
        }
        if (carry == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }

}
