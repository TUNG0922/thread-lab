package com.example.threads_lab.lab07;

public class ForcedLostUpdateDemo {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
          int temp = count;
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          temp = temp + 1;
          count = temp;
        };

        Thread a = new Thread(task);
        Thread b = new Thread(task);
        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Expected 2, got " + count);
    }
}
