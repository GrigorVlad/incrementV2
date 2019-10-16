package me.grigor.benchmark;

import me.grigor.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Benchmark)
public class ForBenchmark {

    private Counter concurrentCounter = new ConcurrentCounter();
    private Counter lockCounter = new LockCounter();
    private Counter mutexCounter = new MutexCounter();
    private Counter magicCounter = new MagicCounter();
    private static final int n = 2;

    @Benchmark
    @Group("ConcurrentCounter")
    @GroupThreads(n)
    public void checkConcurrentIncrement() {
        concurrentCounter.increment();
    }

    @Benchmark
    @Group("ConcurrentCounter")
    @GroupThreads(n)
    public long checkConcurrentGet() {
        return concurrentCounter.getValue();
    }

    @Benchmark
    @Group("LockCounter")
    @GroupThreads(n)
    public void checkLockIncrement() {
        lockCounter.increment();
    }

    @Benchmark
    @Group("LockCounter")
    @GroupThreads(n)
    public long checkLockGet() {
        return lockCounter.getValue();
    }

    @Benchmark
    @Group("MutexCounter")
    @GroupThreads(n)
    public void checkMutexIncrement() {
        mutexCounter.increment();
    }

    @Benchmark
    @Group("MutexCounter")
    @GroupThreads(n)
    public long checkMutexGet() {
        return mutexCounter.getValue();
    }

    @Benchmark
    @Group("MagicCounter")
    @GroupThreads(n)
    public void checkMagicIncrement() {
        magicCounter.increment();
    }

    @Benchmark
    @Group("MagicCounter")
    @GroupThreads(n)
    public long checkMagicGet() {
        return magicCounter.getValue();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ForBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
