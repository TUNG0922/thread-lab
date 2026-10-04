package com.example.threads_lab.lab07;

public class SharedCounterRaceDemo {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException{
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                count++;
            }
        };

        Thread a = new Thread(task, "A");
        Thread b = new Thread(task, "B");
        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Expected 200000, got " + count);
    }
}
