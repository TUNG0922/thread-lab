package com.example.threads_lab.lab06;

public class sleepSubThread {
    public static void main(String[] args) {
        Thread sleeper = new Thread(() -> {
            System.out.println("Sleeping going to sleep");
            try {
                Thread.sleep(3000);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sleeper: woke up");
        });

        sleeper.start();

        for (int i = 0; i < 3; i++) {
            System.out.println("main working " + i);
            try {
                Thread.sleep(500);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
