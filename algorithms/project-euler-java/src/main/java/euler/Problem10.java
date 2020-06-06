package euler;

public class Problem10 {
    // First try
    public long first(long n) {
        long sum = 0;
        for(;n > 1; n--) {
            if (isPrime(n)) {
                sum += n;
            }
        }
        return sum;
    }

    private boolean isPrime(long n) {
        long sqrt = (long) Math.sqrt(n);

        for(long i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Second try
    public long second(long n) {
        long sum = 2;
        // skip evens
        for (long x = 3; x < n; x += 2) {
            if(isPrime(x)) {
                sum += x;
            }
        }
        return sum;
    }
}
