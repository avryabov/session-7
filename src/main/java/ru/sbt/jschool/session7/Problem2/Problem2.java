package ru.sbt.jschool.session7.Problem2;

public class Problem2 {

    private Object obj = new Object();

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.doIt();
    }

    public void doIt() {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
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
                    System.out.println("Thread 2");
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
}
