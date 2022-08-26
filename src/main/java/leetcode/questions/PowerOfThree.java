package leetcode.questions;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return isPowerOfThreeHelper(n);
    }

    private boolean isPowerOfThreeHelper(int n) {
        if (n == 3) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThreeHelper(n / 3);
    }

}
