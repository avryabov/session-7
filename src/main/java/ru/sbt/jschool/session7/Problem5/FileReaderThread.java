package ru.sbt.jschool.session7.Problem5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/**
 */
public class FileReaderThread implements Runnable {

    ConcurrentMap<String, String> fileStore;

    File dir;

    public FileReaderThread(File dir, ConcurrentMap<String, String> fileStore) {
        this.dir = dir;
        this.fileStore = fileStore;
    }

    @Override
    public void run() {
        File[] files = dir.listFiles();
        for(File file: files) {
            if (fileStore.putIfAbsent(file.getName(), "") == null) {
                StringBuffer data = new StringBuffer();
                try (Scanner in = new Scanner(file)) {
                    while (in.hasNext())
                        data.append(in.nextLine()).append("\n");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if (!fileStore.replace(file.getName(), "", data.toString()))
                    throw new RuntimeException("File has read of other Thread");
            }
        }
    }
}
