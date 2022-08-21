package leetcode.questions;

public class MathPow {

    public double myPow(double x, int n) {
        return n < 0 ? (1 / myPowHelper(x, Math.abs(n))) : myPowHelper(x, n);
    }

    private double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = myPowHelper(x, n / 2);
        if (half % 2 == 0) {
            return half * half;
        }
        else {
            return half * half * x;
        }
    }

}
