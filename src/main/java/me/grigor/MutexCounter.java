package me.grigor;

public class MutexCounter implements Counter {

    private volatile long value = 0;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized long getValue() {
        return value;
    }
}
