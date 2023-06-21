package practice.confluent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayedTaskScheduler {

    private DelayedQueue delayedQueue;
    private ExecutorService taskSchedulerThreadPool;
    private ExecutorService workerThreadPool;

    public DelayedTaskScheduler() {
        this.delayedQueue = new DelayedQueue();
        this.taskSchedulerThreadPool = Executors.newFixedThreadPool(2);
        this.workerThreadPool = Executors.newFixedThreadPool(3);
    }

    public void scheduleTask(DelayedTask delayedTask) {
        this.delayedQueue.offer(delayedTask);
    }

    public void startTaskConsumption() {
        taskSchedulerThreadPool.submit(() -> {
            while (true) {
                try {
                    DelayedTask nextTask = this.delayedQueue.take();
                    workerThreadPool.submit(nextTask);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        taskSchedulerThreadPool.submit(() -> {
            while (true) {
                try {
                    DelayedTask nextTask = this.delayedQueue.take();
                    workerThreadPool.submit(nextTask);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
    }

}
