package leetcode.questions;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    Semaphore[] forkLocks;
    Semaphore leftForks;

    public DiningPhilosophers() {
        this.forkLocks = new Semaphore[5];
        for (int i = 0; i < forkLocks.length; i++) {
            this.forkLocks[i] = new Semaphore(1);
        }
        this.leftForks = new Semaphore(4);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftForkId = philosopher;
        int rightForkId = (philosopher + 1) % 5;

        leftForks.acquire();

        forkLocks[leftForkId].acquire();
        forkLocks[rightForkId].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        forkLocks[leftForkId].release();
        forkLocks[rightForkId].release();

        putLeftFork.run();
        putRightFork.run();

        leftForks.release();
    }

}
