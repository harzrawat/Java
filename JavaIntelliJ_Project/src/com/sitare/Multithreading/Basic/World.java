package com.sitare.Multithreading.Basic;

public class World  extends Thread{

    public void run(){
        for (;;){
            System.out.println("World Thread");
        }
    }
    public static void main(String[] args) {

    }
}
