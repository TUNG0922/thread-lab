package com.example.threads_lab.lab06;

public class InterruptException {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
               Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Flag after exception: " + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println("Flag after exception: " + Thread.currentThread().isInterrupted());
            }
        });

        t.start();
        Thread.sleep(500);
        t.interrupt();
    }
}
