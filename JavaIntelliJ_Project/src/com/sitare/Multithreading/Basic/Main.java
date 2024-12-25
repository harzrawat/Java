package com.sitare.Multithreading.Basic;

public class Main {
    public static void main(String[] args) {
        World th1 = new World();
        th1.start();    // this invokes the World thread to run by stopping all other threads in the process (main in this case)

        for (;;){
            System.out.println("thread main");      // this is simply the part of main thread and runs when other thread is paused
        }

        // here both World and main thread share core for interval of time one by one for multiple times to complete the process
        // if directly write one for loop after other then they will run in sequence only, when one finished only then other will start because both are in same thread, and thread excuted in sequence
    }
}
