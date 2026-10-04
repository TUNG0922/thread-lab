package com.example.threads_lab.lab03;

public class mainThreadWait {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                System.out.println("Thread finished");
            }
        };
        t.start();
        System.out.println("main finished");
    }
}
