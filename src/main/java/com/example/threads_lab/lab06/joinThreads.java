package com.example.threads_lab.lab06;

public class joinThreads {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        long begin = System.currentTimeMillis();

        Thread a = new Thread(task);
        Thread b = new Thread(task);

        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Total: " + (System.currentTimeMillis() - begin) + " ms");
    }
}
