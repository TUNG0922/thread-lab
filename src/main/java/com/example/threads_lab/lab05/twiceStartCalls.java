package com.example.threads_lab.lab05;

public class twiceStartCalls {
    public static void main(String[] args) {
        Thread t = new Thread(() ->
                System.out.println("hi"));
        t.start();
        t.start();
    }
}
