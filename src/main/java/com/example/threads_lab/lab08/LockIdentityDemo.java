package com.example.threads_lab.lab08;

public class LockIdentityDemo {

    static class Worker {
        synchronized void work() {                   // locks "this"
            System.out.println(Thread.currentThread().getName() + " entered");
            try { Thread.sleep(1000); } catch (InterruptedException e) { }
        }
    }

    static long run(Worker w1, Worker w2) throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread a = new Thread(w1::work, "A");
        Thread b = new Thread(w2::work, "B");
        a.start();
        b.start();
        a.join();
        b.join();
        return System.currentTimeMillis() - begin;
    }

    public static void main(String[] args) throws InterruptedException {
        Worker shared = new Worker();
        System.out.println("Same object:       ~" + run(shared, shared) + " ms");           // ~2000
        System.out.println("Different objects: ~" + run(new Worker(), new Worker()) + " ms"); // ~1000
    }
}
