package leetcode.questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    Queue<Integer> queue;
    int capacity;
    Lock lock;
    Condition emptyQueue;
    Condition fullQueue;

    public BoundedBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.emptyQueue = this.lock.newCondition();
        this.fullQueue = this.lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                fullQueue.await();
            }
            queue.add(element);
            emptyQueue.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        int result;
        try {
            while (queue.isEmpty()) {
                emptyQueue.await();
            }
            result = queue.poll();
            fullQueue.signalAll();
        }
        finally {
            lock.unlock();
        }
        return result;
    }

    public int size() {
        lock.lock();
        int size;
        try {
            size = queue.size();
        }
        finally {
            lock.unlock();
        }
        return size;
    }

}
