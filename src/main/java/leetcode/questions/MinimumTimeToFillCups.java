package leetcode.questions;

public class MinimumTimeToFillCups {

    public int fillCups(int[] amount) {
        if (amount == null || amount.length != 3) {
            throw new IllegalArgumentException();
        }
        int time = 0;
        while (true) {
            int max = findMaxIndex(amount);
            int secondMax = findSecondMaxIndex(amount, max);
            if (amount[max] != 0 && amount[secondMax] != 0) {
                amount[max]--;
                amount[secondMax]--;
                time++;
            }
            else if (amount[max] != 0 && amount[secondMax] == 0) {
                amount[max]--;
                time++;
            }
            else {
                break;
            }
        }
        return time;
    }

    private int findMaxIndex(int[] amount) {
        int maxIndex = 0;
        if (amount[1] > amount[maxIndex]) {
            maxIndex = 1;
        }
        if (amount[2] > amount[maxIndex]) {
            maxIndex = 2;
        }
        return maxIndex;
    }

    private int findSecondMaxIndex(int[] amount, int maxIndex) {
        if (maxIndex == 0) {
            if (amount[1] > amount[2]) {
                return 1;
            }
            else {
                return 2;
            }
        }
        else if (maxIndex == 1) {
            if (amount[0] > amount[2]) {
                return 0;
            }
            else {
                return 2;
            }
        }
        else {
            if (amount[0] > amount[1]) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }

}
