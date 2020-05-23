package euler;

import org.openjdk.jmh.annotations.*;
// import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.*;


@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(1)
public class Problem07 {
    final static AtomicLong THREAD_INDEX = new AtomicLong(0);

    @State(Scope.Thread)
    public static class ThreadIndex {
        public long value = THREAD_INDEX.getAndIncrement();
    }

    @Benchmark
    public long bench(ThreadIndex n) {
        return exec(n.value);
    }

    public long exec(long n) {
        long count = 0;
        long win = 0;
        for (int i = 2; count < n; i++) {
            if (isPrime(i)) {
                count++;
                win = i;
            }
        }
        return win;
    }

    public boolean isPrime(long n) {
        for (int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
