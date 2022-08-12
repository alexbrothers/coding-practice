package leetcode.questions;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return reverse(x) == x;
    }

    private int reverse(int x) {
        int result = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            result = (result * 10) + digit;
        }
        return result;
    }

}
