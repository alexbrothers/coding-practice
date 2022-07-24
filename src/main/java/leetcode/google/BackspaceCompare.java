package leetcode.google;

public class BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }
        return process(s).equals(process(t));
    }

    private String process(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (current == '#') {
                if (stringBuilder.length() == 0) {
                    continue;
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            else {
                stringBuilder.append(current);
            }
        }
        return stringBuilder.toString();
    }

}
