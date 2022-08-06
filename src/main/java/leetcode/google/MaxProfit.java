package leetcode.google;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }
        int max = 0;
        int prevSmallest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - prevSmallest);
            prevSmallest = Math.min(prevSmallest, prices[i]);
        }
        return max;
    }

}
