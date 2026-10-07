package com.example.threads_lab.lab08;

public class SharedCounterSynchronizedFix {
    static int count = 0;

    static synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
          for (int i = 0; i < 100_000; i++) {
              increment();
          }
        };

        Thread a = new Thread(task);
        Thread b = new Thread(task);
        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Expected 200000, got " + count);
    }
}
