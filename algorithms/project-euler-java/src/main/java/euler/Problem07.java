package euler;

import org.openjdk.jmh.annotations.Benchmark;

public class Problem07 {
    @Benchmark
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
