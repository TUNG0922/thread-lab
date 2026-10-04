package com.example.threads_lab.lab06;

public class sleepThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        // Pause the current thread for about 2 seconds. Here the current thread is main
        Thread.sleep(2000);
        System.out.println("2 seconds later");
    }
}
