package ru.sbt.jschool.session7.Problem1;

public class Problem1 {

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        new Thread(problem1.new MyThread(50)).start();
    }

    public class MyThread implements Runnable {

        private int count = 0;

        public MyThread(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            if(count > 0)
                new Thread(new MyThread(count-1)).start();
            System.out.println("Hello from Thread-" + count);
        }
    }
}
