package com.example.threads_lab.lab06;

public class isInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
           int count = 0;
           while (!Thread.interrupted()) {
               count++;
           }
           System.out.println("Stopped politely after counting to " +count);
        });

        worker.start();
        Thread.sleep(500);
        worker.interrupt();
        worker.join();
    }
}
