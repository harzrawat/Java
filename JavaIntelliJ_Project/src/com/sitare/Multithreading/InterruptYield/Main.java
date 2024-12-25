package com.sitare.Multithreading.InterruptYield;

public class Main implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.yield();     // just a hint to schedular to allow it to give time to other thread also, though it is just a hint not hard and fast instruction
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new Main());
        Thread t2 = new Thread(new Main());

        t1.start();
        t2.start();

    }
}
