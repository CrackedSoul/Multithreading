package com.vic.multi.thread.use;

import java.util.LinkedList;

public class Thread1Test {
    public static void main(String args[]) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();
    }

    //执行顺序与代码顺序无关
    public static void test1() {
        Thread1 t1 = new Thread1();
        t1.start();
        System.out.println("运行结束");
    }

    //线程的随机性
    public static void test2() {
        try {
            Thread2 t2 = new Thread2();
            t2.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //执行顺序与执行start（）顺序无关
    public static void test3() {
        LinkedList<Thread1> thread1s = new LinkedList<Thread1>();
        for (int i = 0; i < 10; i++) {
            thread1s.add(new Thread1(i + 1));
        }
        thread1s.forEach(thread -> {
            thread.start();
        });
    }
    //实现Runable接口
    public static void test4() {
        Runable1 runable1=new Runable1();
        Thread t1=new Thread(runable1);
        t1.start();
        System.out.println("运行结束");
    }
    //不共享数据
    public static void test5() {
        LinkedList<Thread1> thread1s = new LinkedList<Thread1>();
        for (int i = 0; i < 10; i++) {
            thread1s.add(new Thread1(i + 1+"thread"));
        }
        thread1s.forEach(thread -> {
            thread.start();
        });
    }
    //共享数据
    public static void test6(){
        LinkedList<Thread> thread1s = new LinkedList<Thread>();
        Thread3 thread3=new Thread3();
        for (int i = 0; i < 10; i++) {
            thread1s.add(new Thread(thread3,i + 1+"thread"));
        }
        thread1s.forEach(thread -> {
            thread.start();
        });
    }
    //共享数据同步
    public static void test7(){
        LinkedList<Thread> thread1s = new LinkedList<Thread>();
        Thread4 thread3=new Thread4();
        for (int i = 0; i < 10; i++) {
            thread1s.add(new Thread(thread3,i + 1+"thread"));
        }
        thread1s.forEach(thread -> {
            thread.start();
        });
    }
}

class Thread1 extends Thread {
    private int i;
    private int count=5;
    private String name="";

    public Thread1() {
    }

    public Thread1(int i) {
        super();
        this.i = i;
    }
    public Thread1(String name) {
        super();
        this.name= name;
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        if (i == 0&&name.isEmpty())
            System.out.println("MyThread1");
        else if(i!=0)
            System.out.println("i=" + i);
        else if(!name.isEmpty()){
            while (count>0){
                count--;
                System.out.println("由" + this.currentThread().getName()+"计算。count="+count);
            }

        }

    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread3 extends Thread{
    private  int count=10;
    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName()+"计算。count="+count);
    }
}
class Thread4 extends Thread{
    private  int count=10;
    @Override
    synchronized  public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName()+"计算。count="+count);
    }
}
class Runable1 implements Runnable{

    @Override
    public void run() {
        System.out.println("运行中");
    }
}