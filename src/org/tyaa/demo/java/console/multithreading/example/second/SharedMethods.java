package org.tyaa.demo.java.console.multithreading.example.second;

public class SharedMethods {
    private Integer state = 1;
    public void tik () {
        System.out.print("tik");
        state = 2;
    }
    public void dash () {
        System.out.print("-");
        state = 3;
    }
    public void tac () {
        System.out.println("tak");
        state = 1;
    }
    public Integer getState () {
        return state;
    }
}
