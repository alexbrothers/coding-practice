package leetcode.linkedin;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistance {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if (wordsDict == null || word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }
        int min = Integer.MAX_VALUE;
        List<Integer> distances = new ArrayList<>();
        Integer wordTwoLastSeenIndex = null;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word2)) {
                wordTwoLastSeenIndex = i;
                continue;
            }
            if (wordsDict[i].equals(word1)) {
                distances.add(wordTwoLastSeenIndex == null ? Integer.MAX_VALUE : i - wordTwoLastSeenIndex);
            }
        }
        wordTwoLastSeenIndex = null;
        int distancesIndex = distances.size() - 1;
        for (int i = wordsDict.length - 1; i >= 0; i--) {
            if (wordsDict[i].equals(word2)) {
                wordTwoLastSeenIndex = i;
                continue;
            }
            if (wordsDict[i].equals(word1)) {
                int distance = wordTwoLastSeenIndex == null ? Integer.MAX_VALUE : wordTwoLastSeenIndex - i;
                if (distance < distances.get(distancesIndex)) {
                    distances.set(distancesIndex, distance);
                }
                min = Math.min(min, distances.get(distancesIndex));
                distancesIndex--;
                if (distancesIndex < 0) {
                    break;
                }
            }
        }
        return min;
    }

}
