package leetcode.questions;

public class FibinocciNumber {

    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        while (n - 2 >= 0) {
            int next = first + second;
            first = second;
            second = next;
            n--;
        }
        return second;
    }

}
