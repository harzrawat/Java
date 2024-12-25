package com.sitare.Multithreading.InterruptYield;

public class DaemonThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonThread());
        t1.setDaemon(true);         // Daemon thread is a backgroud thread so, if only Daemon thread is running -- JVM stops the process itself as here thread-0 will not bw printed 1000 times but stop way before that
        t1.start();
        System.out.println("main done");
    }
}
