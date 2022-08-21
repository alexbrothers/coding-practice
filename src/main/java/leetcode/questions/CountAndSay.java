package leetcode.questions;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < result.length(); i++) {
            if (i + 1 < result.length() && result.charAt(i) == result.charAt(i + 1)) {
                count++;
            }
            else {
                stringBuilder.append(count);
                stringBuilder.append(result.charAt(i));
                count = 1;
            }
        }
        return stringBuilder.toString();
    }

}
