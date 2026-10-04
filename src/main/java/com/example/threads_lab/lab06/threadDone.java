package com.example.threads_lab.lab06;

public class threadDone {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("done"));
        t.start();
        t.join();
        t.interrupt();
        System.out.println("No error. isInterrupted = " + t.isInterrupted());
    }
}
