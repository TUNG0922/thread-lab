package com.example.threads_lab.lab01;

import java.sql.SQLOutput;

public class ThreadBasics {

    // Way 1: extend Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " (extends Thread): " + i);
                sleepQuietly(100);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Way 2: Runnable (preferred, separates the task from the thread)
        Runnable task = () -> {
            for (int i =1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " (Runnable): " + i);
                sleepQuietly(100);
            }
        };

        Thread t1 = new MyThread();
        Thread t2 = new Thread(task, "worker-A");
        Thread t3 = new Thread(task,"worker-B");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("main: all threads started");

        t1.join();
        t2.join();
        t3.join();

        System.out.println("main: all threads finished");
    }

    static void sleepQuietly(long ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
