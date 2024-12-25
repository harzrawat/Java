package com.sitare.Multithreading.Synchronization;

public class Main implements Runnable{
    static Counter counter = new Counter();
    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Main());
        Thread t2 = new Thread(new Main());

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (Exception e){

        }

        System.out.println(counter.getCounter());
    }
}
