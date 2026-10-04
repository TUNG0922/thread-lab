package com.example.threads_lab.lab02;

public class RaceCondition {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable increment = () -> {
          for (int i = 0; i < 100_000; i++) {
              counter++;
          }
        };

        Thread a = new Thread(increment);
        Thread b = new Thread(increment);

        a.start();
        b.start();

        a.join();
        b.join();

        System.out.println("Expected 200000， got " + counter);
    }
}
