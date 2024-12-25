package com.sitare.Multithreading.InterruptYield;

public class Test implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
//            System.out.println("running");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());     // sleep interrupted by t1.interrupt() code
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new Test());
        Thread t2 = new Thread(new Test());

        t1.start();
        t1.interrupt();
//        System.out.println("end");

    }
}
