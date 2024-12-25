package com.sitare.Multithreading.Synchronization;

public class Counter {
    int counter = 0;

    public void increment(){
        synchronized (this){
            counter++;          // critical code
        }
    }

    // OR

//    public synchronized void increment(){
//            counter++;
//    }
    public int getCounter(){
        return counter;
    }
}
