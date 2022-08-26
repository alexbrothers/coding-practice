package amazon;

public class RadioFrequencies {

    public void matchFrequencies(int[] radioFrequencies, int[] towerFrequencies) {
        if (radioFrequencies == null || towerFrequencies == null || radioFrequencies.length != towerFrequencies.length) {
            throw new IllegalArgumentException();
        }
        quickSortVariation(radioFrequencies, towerFrequencies, 0, radioFrequencies.length - 1, false);
    }

    private void quickSortVariation(int[] frequencies1, int[] frequencies2, int minIndex, int maxIndex, boolean match) {
        if (minIndex > maxIndex) {
            return;
        }
        int pivotValue = frequencies1[minIndex];
        int left = minIndex + 1;
        int right = maxIndex;
        while (left <= right) {
            int leftResult = isMatch(frequencies2[left], pivotValue);
            if (leftResult == -1) {
                left++;
                continue;
            }
            if (leftResult == 0) {
                swap(frequencies2, minIndex, left);
                continue;
            }
            int rightResult = isMatch(frequencies2[right], pivotValue);
            if (rightResult == 1) {
                right--;
                continue;
            }
            if (rightResult == 0) {
                swap(frequencies2, minIndex, right);
            }
            swap(frequencies2, left, right);
        }
        if (!match) {
            quickSortVariation(frequencies2, frequencies1, minIndex, maxIndex, true);
            quickSortVariation(frequencies1, frequencies2, minIndex + 1, right, false);
            quickSortVariation(frequencies1, frequencies2, right + 1, maxIndex, false);
        }
    }

    private void swap(int[] frequencies, int a, int b) {
        int temp = frequencies[a];
        frequencies[a] = frequencies[b];
        frequencies[b] = temp;
    }

    private int isMatch(int towerFrequency, int radioFrequency) {
        if (towerFrequency < radioFrequency) {
            return -1;
        }
        if (towerFrequency > radioFrequency) {
            return 1;
        }
        return 0;
    }

}
