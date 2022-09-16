package leetcode.questions;

public class HitCounter {

    private static final int SECONDS = 300;
    private int[] hits;
    private Integer[] times;

    public HitCounter() {
        this.hits = new int[SECONDS];
        this.times = new Integer[SECONDS];
    }

    public void hit(int timestamp) {
        int convertedTimestamp = timestamp % SECONDS;
        if (times[convertedTimestamp] == null || times[convertedTimestamp] != timestamp) {
            times[convertedTimestamp] = timestamp;
            hits[convertedTimestamp] = 1;
        }
        else {
            hits[convertedTimestamp]++;
        }
    }

    public int getHits(int timestamp) {
        int numHits = 0;
        int min = Math.max(0, timestamp - SECONDS);
        for (int i = 0; i < hits.length; i++) {
            if (times[i] != null && times[i] > min) {
                numHits += hits[i];
            }
        }
        return numHits;
    }

}
