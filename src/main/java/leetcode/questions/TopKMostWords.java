package leetcode.questions;

import java.util.*;

public class TopKMostWords {

    class WordFrequency {
        int frequency;
        String word;

        public WordFrequency(int frequency, String word) {
            this.frequency = frequency;
            this.word = word;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length < k) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<WordFrequency> minHeap = new PriorityQueue<>((a, b) -> {
            int first = Integer.compare(a.frequency, b.frequency);
            if (first != 0) {
                return first;
            }
            return b.word.compareTo(a.word);
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new WordFrequency(entry.getValue(), entry.getKey()));
            }
            else {
                if (minHeap.peek().frequency < entry.getValue() || (minHeap.peek().frequency == entry.getValue() && minHeap.peek().word.compareTo(entry.getKey()) > 0)) {
                    minHeap.poll();
                    minHeap.add(new WordFrequency(entry.getValue(), entry.getKey()));
                }
            }
        }
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().word);
        }
        return result;
    }

}
