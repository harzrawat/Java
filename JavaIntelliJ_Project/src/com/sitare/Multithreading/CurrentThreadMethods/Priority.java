package com.sitare.Multithreading.CurrentThreadMethods;

public class Priority implements Runnable{
//    public Priority(String name){
//        super(name);      // like this is done in only when class extends threads but here we are implementing runnable so there is no need to override constructor
//    }

    @Override
    public void run(){
//        try {
//            Thread.sleep(1000);
//        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " Priority: "+ Thread.currentThread().getPriority());
        }
    }
    public static void main(String[] args) {
        Thread l = new Thread(new Priority(), "low Priority Th");
        Thread m = new Thread(new Priority(), "mid Priority Th");
        Thread h = new Thread(new Priority(), "high Priority Th");

        l.start();
        m.start();
        h.start();



    }
}
