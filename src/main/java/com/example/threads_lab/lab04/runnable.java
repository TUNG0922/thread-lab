package com.example.threads_lab.lab04;

public class runnable {
    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Task run by " + Thread.currentThread().getName());
        }
    }

    public static void main (String[] args) {
        Thread t = new Thread(new MyTask());
        t.start();
    }
}
