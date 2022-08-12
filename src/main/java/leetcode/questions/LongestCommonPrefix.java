package leetcode.questions;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            throw new IllegalArgumentException();
        }
        String longest = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longest = getLongestPrefix(longest, strs[i]);
            if (longest.length() == 0) {
                break;
            }
        }
        return longest;
    }

    private String getLongestPrefix(String longest, String current) {
        StringBuilder stringBuilder = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        while (index1 < longest.length() && index2 < current.length()) {
            if (longest.charAt(index1) == current.charAt(index2)) {
                stringBuilder.append(longest.charAt(index1));
                index1++;
                index2++;
            }
            else {
                break;
            }
        }
        return stringBuilder.toString();
    }

}
