package com.njstack.javastudy.thread;

public class ThreadJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1 end");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2 end");
        });
        t1.start();
        t2.start();
        //正常启动两个线程，应该是T1。先执行完毕。然后是T2执行完毕。
        //但是在T2线程里面调用了T1.join。
        //所以T1线程。先完毕。在执行T2线程。
        //线程点join。作用就是让另外一个线程在当前线。的前面执行。
    }
}