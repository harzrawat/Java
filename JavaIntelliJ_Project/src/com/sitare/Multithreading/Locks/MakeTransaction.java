package com.sitare.Multithreading.Locks;

public class MakeTransaction {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                bank.withdraw(50);
                System.out.println(bank.get());
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}
