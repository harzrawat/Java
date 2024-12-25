package com.sitare.Multithreading.InterruptYield;

public class DaemonThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonThread2());
        Thread t2 = new Thread(new DaemonThread2());

        t1.setDaemon(true);

        t1.start();
        t2.start();

        System.out.println("main done");

        // here both t1 and t2 will keep running as JVM will not stop as in the presence of a user thread (t2) even after main termination and hence the daemon thread will also be executed fully
    }
}
