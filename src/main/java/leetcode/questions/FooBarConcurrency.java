package leetcode.questions;

import java.util.concurrent.atomic.AtomicBoolean;

public class FooBarConcurrency {

    class FooBar {
        private int n;
        private volatile boolean foo;

        public FooBar(int n) {
            this.n = n;
            foo = true;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!foo) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                foo = false;
                notifyAll();
            }
        }

        public synchronized void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (foo) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo = true;
                notifyAll();
            }
        }
    }

}
