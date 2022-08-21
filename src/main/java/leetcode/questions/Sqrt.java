package leetcode.questions;

public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        return mySqrt(x, 1, x / 2);
    }

    private int mySqrt(int x, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + ((right - left) / 2);
        if (willOverflow(mid)) {
            return mySqrt(x, left, mid - 1);
        }
        boolean willNextSquareOverflow = willOverflow(mid + 1);
        int squared = mid * mid;
        int nextSquared = willNextSquareOverflow ? Integer.MAX_VALUE : (mid + 1) * (mid + 1);
        if (squared == x || (squared < x && (willNextSquareOverflow || nextSquared > x))) {
            return mid;
        }
        else if (squared < x) {
            return mySqrt(x, mid + 1, right);
        }
        else {
            return mySqrt(x, left, mid - 1);
        }
    }

    private boolean willOverflow(int num) {
        return (Integer.MAX_VALUE / num) < num;
    }

}
