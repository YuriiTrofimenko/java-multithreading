package org.tyaa.demo.java.console.multithreading.example.second;

public class Processor {

    private Integer id;
    private SharedMethods methods;

    public Processor(Integer id, SharedMethods methods) {
        this.id = id;
        this.methods = methods;
    }

    public void doWork (Integer quantity) {
        new Thread(() -> {
            for (int i = 0; i < quantity; i++) {
                // 1 - защита общего ресурса от неупорядоченных обращений
                // из нескольких потоков
                synchronized (methods) {
                    // 2 - если задача из текущего потока обнаружила,
                    // что ее ИД не соответствует состоянию общего ресурса -
                    while (methods.getState() != id) {
                        // то уступаем очередь ближайшему потоку
                        try {
                            methods.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (id == 1) {
                        methods.tik();
                    } else if (id == 2) {
                        methods.dash();
                    } else {
                        methods.tac();
                    }
                    // 3 - ведомление ближайшему потоку, который уступал очередь,
                    // о том, что работа выполнена, и теперь он снова может попробовать
                    // завершить свою задачу
                    methods.notifyAll();
                }
            }
        }).start();
    }
}
