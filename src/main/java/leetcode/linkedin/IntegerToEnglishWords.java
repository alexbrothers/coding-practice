package leetcode.linkedin;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

    Map<Integer, String> digits = new HashMap<>() {{
        put(0, "Zero");
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
    }};

    Map<Integer, String> outlierTens = new HashMap<>() {{
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
    }};

    Map<Integer, String> tens = new HashMap<>() {{
        put(2, "Twenty");
        put(3, "Thirty");
        put(4, "Forty");
        put(5, "Fifty");
        put(6, "Sixty");
        put(7, "Seventy");
        put(8, "Eighty");
        put(9, "Ninety");
    }};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder stringBuilder = new StringBuilder();
        convert(num, 1, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void convert(int num, int count, StringBuilder stringBuilder) {
        if (num == 0) {
            return;
        }
        convert(num / 1000, count + 1, stringBuilder);
        num = num % 1000;
        if (num == 0) {
            return;
        }
        String converted = convertThreeDigitNumber(num);
        stringBuilder.append(converted);
        stringBuilder.append(getQuantity(count));
    }

    private String getQuantity(int count) {
        if (count == 2) {
            return "Thousand ";
        }
        if (count == 3) {
            return "Million ";
        }
        if (count == 4) {
            return "Billion ";
        }
        return "";
    }

    private String convertThreeDigitNumber(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int divisor;
        if (num >= 100) {
            divisor = 100;
        }
        else if (num >= 10) {
            divisor = 10;
        }
        else {
            divisor = 1;
        }
        while (num > 0) {
            int digit = num / divisor;
            if (divisor == 10) {
                if (digit == 1) {
                    stringBuilder.append(outlierTens.get(num));
                    stringBuilder.append(' ');
                    break;
                }
                else {
                    stringBuilder.append(tens.get(digit));
                    stringBuilder.append(' ');
                }
            }
            else {
                stringBuilder.append(digits.get(digit));
                stringBuilder.append(' ');
            }
            if (divisor == 100) {
                stringBuilder.append("Hundred ");
            }
            num = num % divisor;
            while (divisor > num) {
                divisor = divisor / 10;
            }
        }
        return stringBuilder.toString();
    }

}
