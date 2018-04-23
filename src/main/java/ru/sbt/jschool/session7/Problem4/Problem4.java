package ru.sbt.jschool.session7.Problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem4 {

    private static final int COUNT = 100;

    private Object obj = new Object();
    private volatile int cnt = 0;
    private List<Thread> pool;

    public int doIt() {
        cnt = 0;
        pool = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            Thread thread = new Thread(new MyThread());
            pool.add(thread);
            thread.start();
        }
        for (Thread thread : pool)
            while (thread.isAlive()) {
            }
        return cnt;
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        for (int i = 0; i < 500; i++) {
            int cnt = problem4.doIt();
            System.out.println(cnt);
            assert cnt == COUNT * COUNT;
        }
    }

    public class MyThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                synchronized (obj) {
                    cnt++;
                }
            }
        }
    }
}
