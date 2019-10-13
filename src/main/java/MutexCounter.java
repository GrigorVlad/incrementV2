public class MutexCounter implements Counter {

    private volatile long value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized long getValue() {
        return value;
    }
}
