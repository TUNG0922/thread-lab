package com.example.threads_lab.lab08;

public class BankWithdrawSynchronizedFix {
    static int balance = 100;

    static synchronized void withdraw(int amount) {   // check AND act in one locked unit
        if (balance >= amount) {
            try { Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " withdrew " + amount + ", balance = " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " refused");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> withdraw(100), "A");
        Thread b = new Thread(() -> withdraw(100), "B");
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("Final balance = " + balance);   // always 0
    }
}
