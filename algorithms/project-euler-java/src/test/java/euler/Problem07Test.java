package euler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

class Problem07Test {
    Options opt = new OptionsBuilder()
        .include(Problem07.class.getSimpleName())
        .forks(1)
        .jvmArgs("-server", "-Xms2048m", "-Xmx2048m")
        .measurementIterations(1)
        .mode(Mode.AverageTime)
        .shouldDoGC(true)
        .shouldFailOnError(true)
        .threads(1)
        .warmupIterations(1)
        .warmupTime(TimeValue.seconds(1))
        .build();

    Problem07 l = new Problem07();

    @Test void runBenchmarks() throws RunnerException {
        new Runner(opt).run();
    }

    @Test void testExec() {
        assertEquals(13, l.exec(6));
        assertEquals(104743, l.exec(10001));
    }

    @Test void testIsPrime() {
        assertEquals(true, l.isPrime(2));
        assertEquals(true, l.isPrime(3));
        assertEquals(true, l.isPrime(5));
        assertEquals(true, l.isPrime(7));
        assertEquals(true, l.isPrime(11));
        assertEquals(true, l.isPrime(13));
    }
}
