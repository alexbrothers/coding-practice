package leetcode.questions;


public class SimilarRGB {

    public String similarRGB(String color) {
        if (color == null || color.length() != 7 || color.charAt(0) != '#') {
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder("#");
        for (int i = 1; i < color.length() - 1; i += 2) {
            String sub = color.substring(i, i + 2);
            int target = Integer.parseInt(sub, 16);
            int closest = (int) Math.round(((double) target) / 17);
            result.append(Integer.toHexString(closest));
            result.append(Integer.toHexString(closest));
        }
        return result.toString();
    }

}
