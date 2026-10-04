package com.example.threads_lab.lab06;

public class joinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker done");
        });

        worker.start();
        worker.join();
        System.out.println("main continues after worker");
    }
}
