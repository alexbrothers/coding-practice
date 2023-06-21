package leetcode.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap2 {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap2() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> currentMap = map.getOrDefault(key, new TreeMap<>());
        currentMap.put(timestamp, value);
        map.put(key, currentMap);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        Map.Entry<Integer, String> result = treeMap.floorEntry(timestamp);
        if (result == null) {
            return "";
        }
        return result.getValue();
    }

}
