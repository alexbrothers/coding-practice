package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigArtifacts {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int count = 0;
        int[] artifactSteps = new int[artifacts.length];
        Map<String, Integer> map = new HashMap<>();
        getArtifactCoordinates(artifacts, map, artifactSteps);
        for (int i = 0; i < dig.length; i++) {
            int[] currentDig = dig[i];
            String key = currentDig[0] + ":" + currentDig[1];
            if (map.containsKey(key)) {
                int index = map.get(key);
                artifactSteps[index]--;
                if (artifactSteps[index] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private void getArtifactCoordinates(int[][] artifacts, Map<String, Integer> map, int[] artifactSteps) {
        for (int i = 0; i < artifacts.length; i++) {
            int[] artifact = artifacts[i];
            int startRow = artifact[0];
            int startCol = artifact[1];
            int endRow = artifact[2];
            int endCol = artifact[3];
            for (int row = startRow; row <= endRow; row++) {
                for (int col = startCol; col <= endCol; col++) {
                    String key = row + ":" + col;
                    map.put(key, i);
                    artifactSteps[i]++;
                }
            }
        }
    }

}
