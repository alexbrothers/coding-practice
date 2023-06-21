package practice.confluent;

public class DelayedTask implements Runnable, Comparable<DelayedTask> {

    private long startTime;
    private String taskName;

    public DelayedTask(String taskName, long startTime) {
        this.taskName = taskName;
        this.startTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public void run() {
        System.out.println("Starting task " + taskName + " with start time " + startTime);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(DelayedTask delayedTask) {
        return Long.compare(this.startTime, delayedTask.startTime);
    }
}
