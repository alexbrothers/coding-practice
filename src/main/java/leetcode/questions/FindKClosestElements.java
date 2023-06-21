package leetcode.questions;

import java.util.*;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length < k) {
            throw new IllegalArgumentException();
        }
        int index = binarySearch(arr, 0, arr.length - 1, x);
        Deque<Integer> deque = new ArrayDeque<>();
        if (index < arr.length) {
            deque.add(arr[index]);
        }
        fillRight(deque, arr, index + 1, k);
        fillLeft(deque, arr, index - 1, k, x);
        return new ArrayList<>(deque);
    }

    private void fillRight(Deque<Integer> deque, int[] arr, int index, int k) {
        for (int i = index; i < arr.length && deque.size() < k; i++) {
            deque.addLast(arr[i]);
        }
    }

    private void fillLeft(Deque<Integer> deque, int[] arr, int index, int k, int target) {
        for (int i = index; i >= 0; i--) {
            if (deque.size() < k) {
                deque.addFirst(arr[i]);
            }
            else {
                if (Math.abs(arr[i] - target) <= Math.abs(deque.peekLast() - target)) {
                    deque.pollLast();
                    deque.addFirst(arr[i]);
                }
                else {
                    break;
                }
            }
        }
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return left;
        }
        int mid = left + ((right - left) / 2);
        if (arr[mid] == target) {
            return mid;
        }
        else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, right, target);
        }
        else {
            return binarySearch(arr, left, mid - 1, target);
        }
    }

}
