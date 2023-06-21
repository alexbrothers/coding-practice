package leetcode.questions;

import java.util.*;

public class MaxStack {

    private class StackElement {
        int index;
        int value;

        StackElement(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private Stack<StackElement> stack;
    private PriorityQueue<StackElement> maxHeap;
    private Set<Integer> removed;
    private int count = 0;

    public MaxStack() {
        this.stack = new Stack<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> {
            int first = Integer.compare(b.value, a.value);
            if (first != 0) {
                return first;
            }
            return Integer.compare(b.index, a.index);
        });
        this.removed = new HashSet<>();
    }

    public void push(int x) {
        StackElement stackElement = new StackElement(count, x);
        count++;
        stack.push(stackElement);
        maxHeap.offer(stackElement);
    }

    public int pop() {
        while (!stack.isEmpty() && removed.contains(stack.peek().index)) {
            stack.pop();
        }
        StackElement stackElement = stack.pop();
        removed.add(stackElement.index);
        return stackElement.value;
    }

    public int top() {
        while (!stack.isEmpty() && removed.contains(stack.peek().index)) {
            stack.pop();
        }
        return stack.peek().value;
    }

    public int peekMax() {
        while (!maxHeap.isEmpty() && removed.contains(maxHeap.peek().index)) {
            maxHeap.poll();
        }
        return maxHeap.peek().value;
    }

    public int popMax() {
        while (!maxHeap.isEmpty() && removed.contains(maxHeap.peek().index)) {
            maxHeap.poll();
        }
        StackElement stackElement = maxHeap.poll();
        removed.add(stackElement.index);
        return stackElement.value;
    }
}
