package ru.sbt.jschool.session7.Problem2;

public class Problem2 {

    Object obj = new Object();

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        Thread thread1 = new Thread(problem2.new Thread1());
        Thread thread2 = new Thread(problem2.new Thread2());
        thread1.start();
        thread2.start();
    }

    public class Thread1 implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    System.out.println("Thread 1");
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public class Thread2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread 2");
                    obj.notify();
                }
            }
        }
    }
}
