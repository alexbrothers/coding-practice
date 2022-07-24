package leetcode.google;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            throw new IllegalArgumentException();
        }
        boolean needsMore = increment(digits, digits.length - 1);
        if (needsMore) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    private boolean increment(int[] digits, int index) {
        if (index < 0) {
            return true;
        }
        int digit = digits[index];
        if (digit + 1 == 10) {
            digits[index] = 0;
            return increment(digits, index - 1);
        }
        digits[index] = digit + 1;
        return false;
    }

}
