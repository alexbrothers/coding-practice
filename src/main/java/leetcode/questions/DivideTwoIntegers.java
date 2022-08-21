package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            else {
                return -dividend;
            }
        }
        int negativeCount = 0;
        if (divisor < 0) {
            negativeCount++;
        }
        else {
            divisor = -divisor;
        }
        if (dividend < 0) {
            negativeCount++;
        }
        else {
            dividend = -dividend;
        }
        List<Integer> divisorList = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        int count = 1;
        while (divisor >= dividend) {
            divisorList.add(divisor);
            times.add(count);
            if (divisor < (Integer.MIN_VALUE / 2)) {
                break;
            }
            divisor += divisor;
            count += count;
        }
        int result = 0;
        while (divisorList.size() > 0) {
            int last = divisorList.remove(divisorList.size() - 1);
            int numTimes = times.remove(times.size() - 1);
            if (last >= dividend) {
                result += numTimes;
                dividend -= last;
            }
        }
        return negativeCount == 1 ? result * -1 : result;
    }

}
