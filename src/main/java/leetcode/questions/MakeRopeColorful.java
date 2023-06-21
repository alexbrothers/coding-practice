package leetcode.questions;

public class MakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        if (colors == null || neededTime == null || colors.length() != neededTime.length) {
            throw new IllegalArgumentException();
        }
        int removalTime = 0;
        int currentMaxTime = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (i != 0 && colors.charAt(i - 1) != colors.charAt(i)) {
                currentMaxTime = 0;
            }
            removalTime += Math.min(currentMaxTime, neededTime[i]);
            currentMaxTime = Math.max(currentMaxTime, neededTime[i]);
        }
        return removalTime;
    }

}
