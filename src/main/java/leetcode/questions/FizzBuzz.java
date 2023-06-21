package leetcode.questions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private AtomicInteger num;

    public FizzBuzz(int n) {
        this.n = n;
        this.num = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                while (num.get() != i) {
                    wait();
                }
                printFizz.run();
                num.getAndIncrement();
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                while (num.get() != i) {
                    wait();
                }
                printBuzz.run();
                num.getAndIncrement();
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                while (num.get() != i) {
                    wait();
                }
                printFizzBuzz.run();
                num.getAndIncrement();
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                while (num.get() != i) {
                    wait();
                }
                printNumber.accept(num.getAndIncrement());
                notifyAll();
            }
        }
    }

}
