package ru.sbt.jschool.session7.Problem3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Problem3 {

    private int countThread;
    private CyclicBarrier cyclicBarrier;

    public Problem3(int countThread) {
        this.countThread = countThread;
        cyclicBarrier = new CyclicBarrier(countThread);
    }

    public void doIt() {
        for (int i = 0; i < countThread; i++) {
            new Thread(new MyThread(i + 1)).start();
        }
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3(3);
        problem3.doIt();
    }

    public class MyThread implements Runnable {

        private int num;

        public MyThread(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (true) {
                if (num != cyclicBarrier.getNumberWaiting() + 1) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Thread " + num);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
