package practice.confluent;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DelayedQueue {

    private PriorityQueue<DelayedTask> queue;
    private Lock lock;
    private Condition available;
    private Thread waiting;

    public DelayedQueue() {
        this.queue = new PriorityQueue<>();
        this.lock = new ReentrantLock();
        this.available = lock.newCondition();
        this.waiting = null;
    }

    public void offer(DelayedTask newTask) {
        lock.lock();
        try {
            queue.offer(newTask);
            if (queue.peek() == newTask) {
                waiting = null;
                available.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public DelayedTask take() throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                if (queue.isEmpty()) {
                    available.await();
                }
                else {
                    DelayedTask next = queue.peek();
                    if (next.getStartTime() - System.currentTimeMillis() <= 0) {
                        return queue.poll();
                    }
                    if (waiting != null) {
                        available.await();
                    }
                    else {
                        Thread currentThread = Thread.currentThread();
                        waiting = currentThread;
                        try {
                            available.awaitNanos(next.getStartTime() - System.currentTimeMillis());
                        } finally {
                            if (waiting == currentThread) {
                                waiting = null;
                            }
                        }
                    }
                }
            }
        } finally {
            if (waiting == null && !queue.isEmpty()) {
                available.signal();
            }
            lock.unlock();
        }
    }

}
