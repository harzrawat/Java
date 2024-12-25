package com.sitare.Multithreading.Locks;

public class BankAccount {
    private int balance = 2000;

    public synchronized void withdraw(int amt){
        if (balance>amt){
            balance-=amt;
        }

    }

    public int get(){
        return balance;
    }

    public static void main(String[] args) {

    }
}
