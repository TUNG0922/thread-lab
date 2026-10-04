package com.example.threads_lab.lab04;

public class twoRunnables {
    public static void main(String[] args) {
        Runnable task = () ->
                System.out.println("Running on " + Thread.currentThread().getName());

        new Thread(task, "Worker-1").start();
        new Thread(task, "Worker-2").start();
    }
}
