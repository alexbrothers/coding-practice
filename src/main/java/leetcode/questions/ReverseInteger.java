package leetcode.questions;

public class ReverseInteger {

    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x *= -1;
        }
        int result = 0;
        int multiplier = 10;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            if ((Integer.MAX_VALUE - digit) / multiplier < result) {
                return 0;
            }
            result = (result * 10) + digit;
        }
        return negative ? result * -1 : result;
    }

}
