package org.tyaa.demo.java.console.multithreading;

import org.tyaa.demo.java.console.multithreading.example.second.Processor;
import org.tyaa.demo.java.console.multithreading.example.second.SharedMethods;

public class Main {

    private static final Integer QUANTITY = 10;

    public static void main(String[] args) throws InterruptedException {
        // 1
	    // new Thread(() -> System.out.println("Hello Java Multithreading!")).start();
        // 2
        /* threadStart();
        threadStart(); */
        // 3
        /* Data data = new Data();
        Processor.doWork(data);
        while (!areAllTheThreadsCompleted()) {
            Thread.sleep(1000);
        }
        System.out.println("Static number = " + Data.staticNumber);
        System.out.println("Number = " + data.number);
        System.out.println("The End."); */
        // 4
        /* SharedMethods sharedMethods = new SharedMethods();
        new Processor(1, sharedMethods).doWork(QUANTITY);
        new Processor(2, sharedMethods).doWork(QUANTITY);
        new Processor(3, sharedMethods).doWork(QUANTITY); */
        // 5
        // Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t1.setDaemon(true);
        t1.start();
        t1.join(1000);
        // t1.interrupt();
        System.out.println("The End.");
    }

    /* private static void threadStart() {
        new Thread(Main::task).start();
    } */

    /* private static void task() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("Hello Java Multithreading! (%s, #%d)\n", Thread.currentThread().getName(), i);
        }
    } */

    /* private static Boolean areAllTheThreadsCompleted() {
        return Processor.completionsMap.containsKey("Thread-0")
                && Processor.completionsMap.containsKey("Thread-1")
                && Processor.completionsMap.containsKey("Thread-2")
                && Processor.completionsMap.containsKey("Thread-3");
    } */
}
