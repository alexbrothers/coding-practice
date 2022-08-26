package leetcode.questions;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException();
        }
        int[] parents = new int[accounts.size()];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (map.containsKey(email)) {
                    union(parents, i, map.get(email));
                }
                else {
                    map.put(email, i);
                }
            }
        }
        Map<Integer, Set<String>> results = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int parentIndex = find(parents, i);
            Set<String> emails = results.getOrDefault(parentIndex, new HashSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) {
                emails.add(accounts.get(i).get(j));
            }
            results.put(parentIndex, emails);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : results.entrySet()) {
            PriorityQueue<String> minHeap = new PriorityQueue<>(entry.getValue());
            List<String> account = new ArrayList<>();
            account.add(accounts.get(entry.getKey()).get(0));
            while (!minHeap.isEmpty()) {
                account.add(minHeap.poll());
            }
            result.add(account);
        }
        return result;
    }

    private int find(int[] parents, int index) {
        if (parents[index] == index) {
            return index;
        }
        return find(parents, parents[index]);
    }

    private void union(int[] parents, int a, int b) {
        int parentA = find(parents, a);
        int parentB = find(parents, b);
        if (parentA != parentB) {
            parents[parentA] = parentB;
        }
    }

}
