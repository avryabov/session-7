package ru.sbt.jschool.session7.Problem5;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 */
public class CalcWordsThread implements Runnable {

    private ConcurrentMap<String, String> fileStore;
    private boolean work;

    public CalcWordsThread(ConcurrentMap<String, String> fileStore) {
        this.fileStore = fileStore;
        this.work = true;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    @Override
    public void run() {
        while (isWork()) {
            calcMap();
        }
        calcMap();
    }

    private void calcMap() {
        for (Map.Entry<String, String> entry : fileStore.entrySet()) {
            if (!entry.getValue().equals("")) {
                System.out.println(entry.getKey() + " has " + calcWords(entry.getValue()) + " words");
                entry.setValue("");
            }
        }
    }

    private int calcWords(String data) {
        String[] arr = data.split(" ");
        return arr.length;
    }
}
