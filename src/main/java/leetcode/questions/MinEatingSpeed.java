package leetcode.questions;

public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h < 1) {
            throw new IllegalArgumentException();
        }
        int max = Integer.MIN_VALUE;
        int min = 1;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        Integer answer = null;
        while (min <= max) {
            int mid = min + ((max - min) / 2);
            long hoursNeeded = numHoursNeeded(piles, mid);
            if (hoursNeeded == h) {
                if (answer == null) {
                    answer = mid;
                }
                else {
                    answer = Math.min(answer, mid);
                }
                max = mid - 1;
            }
            else if (hoursNeeded < h) {
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        return answer == null ? min : answer;
    }

    private long numHoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] % k == 0) {
                hours += piles[i] / k;
            }
            else {
                hours += (piles[i] / k) + 1;
            }
        }
        return hours;
    }

}
