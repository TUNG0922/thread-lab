package com.example.threads_lab.lab06;

public class joinTimeLimit {
    public static void main(String[] args) throws InterruptedException {
        Thread slow = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        slow.start();
        slow.join(1000);
        System.out.println("Still alive? " + slow.isAlive());
    }
}
