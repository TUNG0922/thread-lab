package com.example.threads_lab.lab05;

public class threadSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable sleepy = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        };

        long begin = System.currentTimeMillis();
        new Thread(sleepy).start();
        new Thread(sleepy).start();
        Thread.sleep(1100); // just waiting so both can finish
        System.out.println("Total: " + (System.currentTimeMillis() - begin) + " ms");
    }
}
