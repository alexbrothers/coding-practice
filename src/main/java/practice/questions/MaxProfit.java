package practice.questions;

public class MaxProfit {

    public static long solution(long[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        if (prices.length < 2) {
            return 0;
        }
        long max = 0;
        long minPriceSeen = prices[0];
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minPriceSeen);
            minPriceSeen = Math.min(minPriceSeen, prices[i]);
        }
        return max;
    }

}
