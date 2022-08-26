package leetcode.questions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        ListNode(int key, int value, ListNode next, ListNode prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        if (node == head) {
            return node.value;
        }
        if (node == tail) {
            evict();
            addToFront(node);
            return node.value;
        }
        removeConnections(node);
        addToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            ListNode add = new ListNode(key, value);
            if (size == capacity) {
                map.remove(tail.key);
                evict();
                size--;
            }
            map.put(key, add);
            addToFront(add);
            size++;
        }
        else {
            ListNode existing = map.get(key);
            existing.value = value;
            if (existing == head) {
                return;
            }
            if (existing == tail) {
                evict();
            }
            else {
                removeConnections(existing);
            }
            addToFront(existing);
        }
    }

    private void removeConnections(ListNode node) {
        if (node == tail) {
            evict();
        }
        else {
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }
    }

    private void addToFront(ListNode node) {
        if (size == 0) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void evict() {
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            ListNode remove = tail;
            tail = tail.prev;
            tail.next = null;
            remove.prev = null;
        }
    }

}
