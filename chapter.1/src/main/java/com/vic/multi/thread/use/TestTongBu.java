package com.vic.multi.thread.use;

public class TestTongBu {
    public static void main(String args[]) {
//        Test1();
        Test2();
    }

    private static void Test1() {
        Thread thread1 = new Thread(() -> {
            LoginServlet.doPost("a", "aa");
        }
        );
        Thread thread2 = new Thread(() -> {
            LoginServlet.doPost("b", "bb");
        }
        );
        thread1.start();
        thread2.start();
    }

    private static void Test2() {
        Thread thread1 = new Thread(() -> {
            LoginServlet.doGet("a", "aa");
        }
        );
        Thread thread2 = new Thread(() -> {
            LoginServlet.doGet("b", "bb");
        }
        );
        thread1.start();
        thread2.start();
    }

}

class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a"))
                Thread.sleep(1000);
            passwordRef = password;
            System.out.println("UserName:" + usernameRef + ",Password:" + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void doGet(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a"))
                Thread.sleep(1000);
            passwordRef = password;
            System.out.println("UserName:" + usernameRef + ",Password:" + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
