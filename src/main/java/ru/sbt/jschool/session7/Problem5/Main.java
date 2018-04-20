package ru.sbt.jschool.session7.Problem5;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 */
public class Main {

    private static final String DIR = "src/main/java/ru/sbt/jschool/session7/Problem5/resources";

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            File dir = new File(DIR);
            ConcurrentMap<String, String> fileStore = new ConcurrentHashMap<>();

            FileReaderThread reader1 = new FileReaderThread(dir, fileStore);
            FileReaderThread reader2 = new FileReaderThread(dir, fileStore);
            CalcWordsThread calc = new CalcWordsThread(fileStore);

            Thread threadReader1 = new Thread(reader1);
            Thread threadReader2 = new Thread(reader2);
            Thread threadCalc = new Thread(calc);

            threadCalc.start();
            threadReader1.start();
            threadReader2.start();

            threadReader1.join();
            threadReader2.join();
            calc.setWork(false);
            threadCalc.join();

            int size = fileStore.size();
            //System.out.println(size);
            //System.out.println(fileStore);
            assert size == 7;

        }
    }
}
