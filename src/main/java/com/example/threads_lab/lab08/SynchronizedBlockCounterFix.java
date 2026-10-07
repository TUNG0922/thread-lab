package com.example.threads_lab.lab08;

public class SynchronizedBlockCounterFix {

    static class Counter {
        private int count = 0;
        private final Object lock = new Object();

        void increment() {
            // work that touches no shared data can stay OUTSIDE the lock
            synchronized (lock) {                    // only the critical section is locked
                count++;
            }
        }

        int get() {
            synchronized (lock) {
                return count;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = () -> {
            for  (int i = 1; i <= 100_000; i++) {
                counter.increment();
            }
        };

        Thread a = new Thread(task);
        Thread b = new Thread(task);
        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Expected 200000, got " + counter.get());
    }
}
