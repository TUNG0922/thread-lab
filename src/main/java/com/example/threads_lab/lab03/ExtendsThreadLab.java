package com.example.threads_lab.lab03;

public class ExtendsThreadLab {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + getName());
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
