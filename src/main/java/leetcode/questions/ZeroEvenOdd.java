package leetcode.questions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);
    AtomicInteger count = new AtomicInteger(1);
    int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (count.get() % 2 == 0) {
                even.release();
            }
            else {
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n / 2; i++) {
            even.acquire();
            printNumber.accept(count.getAndIncrement());
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int times = n % 2 == 0 ? n / 2 : (n / 2) + 1;
        for (int i = 0; i < times; i++) {
            odd.acquire();
            printNumber.accept(count.getAndIncrement());
            zero.release();
        }
    }

}
