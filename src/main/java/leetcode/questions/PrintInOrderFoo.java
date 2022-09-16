package leetcode.questions;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintInOrderFoo {

    class Foo {

        private AtomicInteger count;

        public Foo() {
            count = new AtomicInteger(1);
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            count.getAndIncrement();
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (count.get() != 2) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            count.getAndIncrement();
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (count.get() != 3) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            notifyAll();
        }
    }

}
