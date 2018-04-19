package ru.sbt.jschool.session7.Problem5;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 */
public class CalcWordsThread implements Runnable {

    ConcurrentMap<String, String> fileStore;

    public CalcWordsThread(ConcurrentMap<String, String> fileStore) {
        this.fileStore = fileStore;
    }

    @Override
    public void run() {
        while(true) {
            for(Map.Entry<String, String> entry: fileStore.entrySet()) {
                if(!entry.getValue().equals("")) {
                    System.out.println(entry.getKey() + " has " + calcWords(entry.getValue()) + " words");
                    entry.setValue("");
                }
            }
        }
    }

    private int calcWords(String data) {
        String[] arr = data.split(" |\\n");
//        for(String s: arr) {
//            System.out.println(s);
//        }
        return arr.length;
    }
}
