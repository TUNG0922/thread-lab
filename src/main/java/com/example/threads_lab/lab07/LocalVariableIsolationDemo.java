package com.example.threads_lab.lab07;

public class LocalVariableIsolationDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
          int local = 0;
          for (int i = 1; i <= 100_000; i++) {
              local++;
          }
          System.out.println(Thread.currentThread().getName() + " local = " + local);
        };

        Thread a = new Thread(task);
        Thread b = new Thread(task);
        a.start();
        b.start();
        a.join();
        b.join();
    }
}
