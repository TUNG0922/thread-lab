package com.example.threads_lab.lab06;

public class interruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread sleeper = new Thread(() -> {
           try {
               System.out.println("Sleeping for 10 seconds...");
               Thread.sleep(10_000);
               System.out.println("Woke up normally");
           } catch (InterruptedException e) {
               System.out.println("Interrupted while sleeping!");
           }
        });

        sleeper.start();
        Thread.sleep(1000);
        sleeper.interrupt();
    }
}
