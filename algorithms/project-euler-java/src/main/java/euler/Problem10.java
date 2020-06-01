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
        int counter = 0;
        long sqrt = (long) Math.sqrt(n);

        for(long i = 1; i <= sqrt; i++) {
            if(n % i == 0) {
                counter++;
            }
            if(counter > 1) {
                return false;
            }
        }

        return true;
    }

    // Second try
    public long second(long n) {
        return -1;
    }
}
