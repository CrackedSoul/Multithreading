package com.vic.multi.thread.section14;

/*
 * 只有线程自己调用start()方法时， Thread.currentThread()==this
 *
 *
 */
public class Alive {
    public static void main(String args[]) {
//        Test1();
        Test2();
    }

    public static void Test1() {
        try {
            Thread1 t = new Thread1();
            System.out.println("begin==" + t.isAlive());
            t.start();
            Thread.sleep(100);
            System.out.println("end==" + t.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void Test2() {
        Thread2 thread2 = new Thread2();
        thread2.start();
//        Thread thread = new Thread(thread2);
//        System.out.println("Main begin thread2 isAlive=" + thread2.isAlive());
//        System.out.println("Main begin thread isAlive=" + thread.isAlive());
//        thread.setName("A");
//        thread.start();
//        System.out.println("Main end thread isAlive=" + thread.isAlive());
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("RUN==:" + this.isAlive());
    }
}

class Thread2 extends Thread {
    public Thread2() {
        super();
        System.out.println("new Thread Begin:");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.getId()=" + this.getId());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("new Thread End");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run Begin:");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.getId()=" + this.getId());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("Thread.currentThread()==this ="+(Thread.currentThread()==this));
        System.out.println("run End");
    }
}