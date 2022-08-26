package leetcode.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    class TimeValue {
        int timestamp;
        String value;

        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    class BinarySearchResult {
        int index;
        boolean found;

        BinarySearchResult(int index, boolean found) {
            this.index = index;
            this.found = found;
        }
    }

    Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TimeValue timeValue = new TimeValue(timestamp, value);
        List<TimeValue> list = map.getOrDefault(key, new ArrayList<>());
        list.add(timeValue);
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<TimeValue> list = map.get(key);
        if (list == null) {
            return "";
        }
        BinarySearchResult result = binarySearch(list, timestamp, 0, list.size() - 1);
        if (result.found) {
            return list.get(result.index).value;
        }
        else {
            if (result.index == 0) {
                return "";
            }
            return list.get(result.index - 1).value;
        }
    }

    private BinarySearchResult binarySearch(List<TimeValue> list, int target, int left, int right) {
        if (left > right) {
            return new BinarySearchResult(left, false);
        }
        int mid = left + ((right - left) / 2);
        int midValue = list.get(mid).timestamp;
        if (midValue == target) {
            return new BinarySearchResult(mid, true);
        }
        if (midValue < target) {
            return binarySearch(list, target, mid + 1, right);
        }
        else {
            return binarySearch(list, target, left, mid - 1);
        }
    }

}
