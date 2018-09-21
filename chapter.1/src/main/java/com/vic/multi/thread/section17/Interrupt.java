package com.vic.multi.thread.section17;

public class Interrupt {
    public static void main(String args[]) {
        Test1();
    }

    public static void Test1() {
        try {
            Thread t1 = new Thread1();
            Thread t2 = new Thread(t1);
//            t2.start();
            Thread.sleep(500);
//            t2.interrupt();
            t1.interrupt();
            System.out.println("t1.isInterrupted()=" + t1.isInterrupted());
            t1.start();
            Thread.sleep(500);
            t1.interrupt();
            System.out.println("t1.isInterrupted()=" + t1.isInterrupted());
//            System.out.println("t2.isInterrupted()=" + t2.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(this);
        System.out.println(this.currentThread());
        while (!this.currentThread().isInterrupted()) {

        }
        System.out.println("interrupted");
        while(true){}


//        return;
    }
}