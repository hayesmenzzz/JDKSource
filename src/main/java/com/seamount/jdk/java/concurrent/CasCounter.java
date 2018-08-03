package com.seamount.jdk.java.concurrent;

public class CasCounter {

    private SimulatedCAS value;

    public int getValue() {
        return value.getValue();
    }

    public int decrement() {
        int oldValue = value.getValue();
        while (value.compareAndSwap(oldValue, oldValue + 1) != oldValue) {
            oldValue = value.getValue();
        }
        return oldValue + 1;
    }
}
