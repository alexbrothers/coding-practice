package leetcode.questions;

public class LargestTime {

    public String largestTimeFromDigits(int[] arr) {
        if (arr == null || arr.length != 4) {
            throw new IllegalArgumentException();
        }
        int[] counts = countDigits(arr);
        for (int hour = 23; hour >= 0; hour--) {
            int second = hour % 10;
            int first = hour / 10;
            if (canMake(counts, first, second)) {
                counts[first]--;
                counts[second]--;
                for (int min = 59; min >= 0; min--) {
                    int secondMin = min % 10;
                    int firstMin = min / 10;
                    if (canMake(counts, firstMin, secondMin)) {
                        return makeResult(first, second, firstMin, secondMin);
                    }
                }
                counts[first]++;
                counts[second]++;
            }
        }
        return "";
    }

    private String makeResult(int firstHour, int secondHour, int firstMin, int secondMin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstHour);
        stringBuilder.append(secondHour);
        stringBuilder.append(':');
        stringBuilder.append(firstMin);
        stringBuilder.append(secondMin);
        return stringBuilder.toString();
    }

    private boolean canMake(int[] counts, int first, int second) {
        if (first == second) {
            return counts[first] > 1;
        }
        return counts[first] > 0 && counts[second] > 0;
    }

    private int[] countDigits(int[] arr) {
        int[] counts = new int[10];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        return counts;
    }

}
