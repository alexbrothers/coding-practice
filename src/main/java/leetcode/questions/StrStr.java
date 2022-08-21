package leetcode.questions;

public class StrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            throw new IllegalArgumentException();
        }
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (isMatch(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isMatch(String haystack, String needle, int start) {
        int index1 = start;
        int index2 = 0;
        while (index2 < needle.length()) {
            if (haystack.charAt(index1) != needle.charAt(index2)) {
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }

}
