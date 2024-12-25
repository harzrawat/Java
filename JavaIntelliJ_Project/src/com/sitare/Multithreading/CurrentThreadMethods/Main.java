package com.sitare.Multithreading.CurrentThreadMethods;

public class Main implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName()+" Priority: "+Thread.currentThread().getPriority());
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Thread t1 = new Thread(main);
        System.out.println(Thread.currentThread().getName() +" "+Thread.currentThread().getPriority()); // by default priority is 5 for each thread
        t1.start();
//        t1.join();
    }
}
