package com.vic.multi.thread.section13;

public class Curren {
    public static void main(String args[]) {
//        Test1();
//        Test2();
        Test3();
    }

    public static void Test1() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void Test2() {
        Thread1 thread1 = new Thread1();
//        thread1.start();
        thread1.run();
    }

    public static void Test3() {
        Thread t1 = new Thread2();
        Thread t2=new Thread(t1);
        t1.setName("A");
        t1.start();
        t2.setName("B");
        t2.start();
    }
}

class Thread1 extends Thread {
    public Thread1() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());
    }
}

class Thread2 extends Thread {
    public Thread2() {
        System.out.println("New Thread2 Begin:");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("New Thread2 End");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Run Thread2 Begin:");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("Run Thread2 End");
    }
}
