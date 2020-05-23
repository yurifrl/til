package euler;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


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
