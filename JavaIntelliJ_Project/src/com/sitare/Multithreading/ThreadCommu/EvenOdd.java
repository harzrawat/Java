package com.sitare.Multithreading.ThreadCommu;


public class EvenOdd {
    private static int currentNumber = 1;
    private static final int MAX_NUMBER = 20;
    private static final Object MONITOR = new Object();

    // Method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Prime Number Printing Thread
    static class PrimeThread extends Thread {
        @Override
        public void run() {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (MONITOR) {
                    // Check if current number is prime
                    if (isPrime(currentNumber)) {
                        System.out.println("Prime Thread: " + currentNumber);
                        currentNumber++;
                    }

                    // Notify waiting threads
                    MONITOR.notify();

                    // If not prime, wait for non-prime thread
                    try {
                        if (currentNumber <= MAX_NUMBER) {
                            MONITOR.wait();
                        }
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }
    }

    // Non-Prime Number Printing Thread
    static class NonPrimeThread extends Thread {
        @Override
        public void run() {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (MONITOR) {
                    // Check if current number is non-prime
                    if (!isPrime(currentNumber)) {
                        System.out.println("Non-Prime Thread: " + currentNumber);
                        currentNumber++;
                    }

                    // Notify waiting threads
                    MONITOR.notify();

                    // If prime, wait for prime thread
                    try {
                        if (currentNumber <= MAX_NUMBER) {
                            MONITOR.wait();
                        }
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrimeThread primeThread = new PrimeThread();
        NonPrimeThread nonPrimeThread = new NonPrimeThread();

        primeThread.start();
        nonPrimeThread.start();

        try {
            primeThread.join();
            nonPrimeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}