package org.tyaa.demo.java.console.multithreading.example.first;

import java.util.HashMap;
import java.util.Map;

public class Processor {
    public static Map<String, Boolean> completionsMap = new HashMap<>();
    public static void doWork(Data data) {
        staticAdd();
        staticAdd();
        new Processor().add(data);
        new Processor().add(data);
    }
    private static void staticAdd() {
        new Thread(() -> {
            staticAddTask();
        }).start();
    }
    private void add(Data data) {
        new Thread(() -> {
            synchronized (data) {
                for (int i = 0; i < 100; i++) {
                    data.number++;
                }
                completionsMap.put(Thread.currentThread().getName(), true);
            }
        }).start();
    }

    private synchronized static void staticAddTask() {
        for (int i = 0; i < 100; i++) {
            Integer x = Data.staticNumber;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Data.staticNumber = x;
        }
        completionsMap.put(Thread.currentThread().getName(), true);
    }
}
