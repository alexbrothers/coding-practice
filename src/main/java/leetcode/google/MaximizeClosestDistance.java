package leetcode.google;

public class MaximizeClosestDistance {

    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length < 2) {
            throw new IllegalArgumentException();
        }
        int[] closest = new int[seats.length];
        int nextClosest = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < closest.length; i++) {
            if (seats[i] == 1) {
                nextClosest = i;
            }
            closest[i] = Math.abs(nextClosest - i);
        }
        nextClosest = Integer.MAX_VALUE;
        for (int i = closest.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                nextClosest = i;
            }
            closest[i] = Math.min(closest[i], nextClosest - i);
            result = Math.max(result, closest[i]);
        }
        return result;
    }

}
