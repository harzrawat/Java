//package com.sitare.Multithreading.Locks;
//
//class Pen {
//    public synchronized void writeWithPenAndPaper(Paper paper) {
//        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to use paper " + paper);
//        paper.finishWriting(); // Tries to lock paper
//    }
//
//    public synchronized void finishWriting() {
//        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
//    }
//}
//
//class Paper {
//    public synchronized void writeWithPaperAndPen(Pen pen) {
//        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to use pen " + pen);
//        pen.finishWriting(); // Tries to lock pen
//    }
//
//    public synchronized void finishWriting() {
//        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
//    }
//}
//
//class Task1 implements Runnable {
//    private Pen pen;
//    private Paper paper;
//
//    public Task1(Pen pen, Paper paper) {
//        this.pen = pen;
//        this.paper = paper;
//    }
//
//    @Override
//    public void run() {
//        synchronized (pen) { // Thread-1 locks pen
//            try {
//                Thread.sleep(50); // Simulate some work
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            paper.writeWithPaperAndPen(pen); // Then tries to lock paper
//        }
//    }
//}
//
//class Task2 implements Runnable {
//    private Pen pen;
//    private Paper paper;
//
//    public Task2(Pen pen, Paper paper) {
//        this.pen = pen;
//        this.paper = paper;
//    }
//
//    @Override
//    public void run() {
//        synchronized (paper) { // Thread-2 locks paper
//            try {
//                Thread.sleep(50); // Simulate some work
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            pen.writeWithPenAndPaper(paper); // Then tries to lock pen
//        }
//    }
//}
//
//public class DeadLock {
//    public static void main(String[] args) {
//        Pen pen = new Pen();
//        Paper paper = new Paper();
//
//        Thread thread1 = new Thread(new Task1(pen, paper), "Thread-1");
//        Thread thread2 = new Thread(new Task2(pen, paper), "Thread-2");
//
//        thread1.start();
//        thread2.start();
//    }
//}

class Resource1 {
    public synchronized void method1(Resource2 r2) {
        System.out.println(Thread.currentThread().getName() + " locked Resource1, waiting for Resource2...");
        try { Thread.sleep(50); } catch (InterruptedException e) {}
        r2.method2();
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " locked Resource1 completely.");
    }
}

class Resource2 {
    public synchronized void method1(Resource1 r1) {
        System.out.println(Thread.currentThread().getName() + " locked Resource2, waiting for Resource1...");
        try { Thread.sleep(50); } catch (InterruptedException e) {}
        r1.method2();
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " locked Resource2 completely.");
    }
}

public class DeadLock {
    public static void main(String[] args) {
        Resource1 r1 = new Resource1();
        Resource2 r2 = new Resource2();

        Thread t1 = new Thread(() -> r1.method1(r2), "Thread-1");
        Thread t2 = new Thread(() -> r2.method1(r1), "Thread-2");

        t1.start();
        t2.start();
    }
}
