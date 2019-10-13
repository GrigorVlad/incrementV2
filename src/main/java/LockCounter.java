import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Counter {

    private Lock locker = new ReentrantLock();
    private long value = 0;

    @Override
    public void increment() {
        locker.lock();
        try {
            value++;
        } finally {
            locker.unlock();
        }

    }

    @Override
    public long getValue() {
        return value;
    }
}
