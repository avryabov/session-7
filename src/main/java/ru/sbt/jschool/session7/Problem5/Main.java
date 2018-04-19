package ru.sbt.jschool.session7.Problem5;

import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/**
 */
public class Main {

    private static final String DIR = "/tmp/problem5/";

    public static void main(String[] args) {
        for(int i = 0; i < 1; i++ ) {
            File dir = new File(DIR);
            ConcurrentMap<String, String> fileStore = new ConcurrentHashMap<>();
            ConcurrentLinkedQueue fileQueue = new ConcurrentLinkedQueue();

            FileReaderThread reader1 = new FileReaderThread(dir, fileStore);
            FileReaderThread reader2 = new FileReaderThread(dir, fileStore);
            CalcWordsThread calc = new CalcWordsThread(fileStore);

            Thread thread1 = new Thread(reader1);
            Thread thread2 = new Thread(reader2);
            Thread thread3 = new Thread(calc);

            thread3.start();
            thread1.start();
            thread2.start();


            while (thread3.isAlive()) {}
            //while (thread1.isAlive() || thread2.isAlive()) {}

            //System.out.println(fileQueue);
            int size = fileStore.size();
            System.out.println(size);
            assert size == 5;

        }
    }
}
