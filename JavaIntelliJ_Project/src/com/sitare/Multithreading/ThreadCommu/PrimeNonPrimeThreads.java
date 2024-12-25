//package com.sitare.Multithreading.ThreadCommu;
//
//class SharedResource {
//    private int currentNumber;
//    private boolean isPrimeNumberTurn = true;
//
//    // Method to check if a number is prime
//    private boolean isPrime(int n) {
//        if (n <= 1) return false;
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) return false;
//        }
//        return true;
//    }
//
//    public synchronized void printPrimeNumbers(int number) {
//        while (!isPrimeNumberTurn) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                return;
//            }
//        }
//
//        if (isPrime(number)) {
//            System.out.println("Prime Thread: " + number);
//            isPrimeNumberTurn = false;
//            notify();
//        }
//    }
//
//    public synchronized void printNonPrimeNumbers(int number) {
//        while (isPrimeNumberTurn) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                return;
//            }
//        }
//
//        if (!isPrime(number)) {
//            System.out.println("Non-Prime Thread: " + number);
//            isPrimeNumberTurn = true;
//            notify();
//        }
//    }
//}
//
//class PrimeNumberPrinter implements Runnable {
//    private SharedResource resource;
//
//    public PrimeNumberPrinter(SharedResource resource) {
//        this.resource = resource;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 20; i++) {
//            resource.printPrimeNumbers(i);
//        }
//    }
//}
//
//class NonPrimeNumberPrinter implements Runnable {
//    private SharedResource resource;
//
//    public NonPrimeNumberPrinter(SharedResource resource) {
//        this.resource = resource;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 1; i <= 20; i++) {
//            resource.printNonPrimeNumbers(i);
//        }
//    }
//}
//
//public class PrimeNonPrimeThreads {
//    public static void main(String[] args) {
//        SharedResource resource = new SharedResource();
//
//        Thread primeThread = new Thread(new PrimeNumberPrinter(resource));
//        Thread nonPrimeThread = new Thread(new NonPrimeNumberPrinter(resource));
//
//        primeThread.start();
//        nonPrimeThread.start();
//
//        try {
//            primeThread.join();
//            nonPrimeThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
