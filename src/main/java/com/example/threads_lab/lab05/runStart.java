package com.example.threads_lab.lab05;

public class runStart {
    public static void main(String[] args) {
        Thread t = new Thread(() ->
        System.out.println("Running on: " + Thread.currentThread().getName()));

        t.run();
        t.start();
    }
}
