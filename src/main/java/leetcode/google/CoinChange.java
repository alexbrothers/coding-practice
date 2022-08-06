package leetcode.google;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            throw new IllegalArgumentException();
        }
        Integer[] amounts = new Integer[amount + 1];
        amounts[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j < amounts.length; j++) {
                if (coin > j) {
                    continue;
                }
                Integer previous = amounts[j - coin];
                if (previous == null) {
                    continue;
                }
                if (amounts[j] == null) {
                    amounts[j] = previous + 1;
                }
                else {
                    amounts[j] = Math.min(amounts[j], previous + 1);
                }
            }
        }
        return amounts[amounts.length - 1] == null ? -1 : amounts[amounts.length - 1];
    }

}
