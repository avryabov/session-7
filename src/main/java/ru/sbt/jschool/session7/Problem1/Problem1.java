package ru.sbt.jschool.session7.Problem1;

import java.util.concurrent.atomic.AtomicInteger;

public class Problem1 {

    private final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        new Thread(problem1.new MyThread()).start();
    }

    public class MyThread implements Runnable {

        @Override
        public void run() {
            int cnt = count.incrementAndGet();
            if(cnt < 50) {
                Thread thread = new Thread(new MyThread());
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hello from Thread-" + cnt);
        }
    }
}
