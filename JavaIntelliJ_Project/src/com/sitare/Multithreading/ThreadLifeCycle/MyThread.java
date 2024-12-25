package com.sitare.Multithreading.ThreadLifeCycle;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " Running");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();       // by default , name of this thread is thread-0 and below one is named thread-1
        MyThread t2 = new MyThread();

        System.out.println(t1.getState());  // NEW
        t1.start();
        t2.start();
        System.out.println(t1.getState());      // RUNNABLE
        Thread.sleep(200);              // .sleep is a static method, hence can be called inside Thread class itself only ( so that only sleeps the current calling thread)
        System.out.println(t1.getState());      // TIMED_WAITING
        t1.join();          // make the calling thread (main) to wait for t1 thread
        System.out.println(t1.getState());      // TERMINATED
    }
}
