package euler;

import java.util.*;

public class Problem12 {
    public long first(long n) {
        long current = 0;

        for(int i = 1; ;i++) {
            current += i;
            // Check factors count
            long factorsCount = countFactors(current);
            System.out.printf("%d factor count is: %d \n", current, factorsCount);
            if(factorsCount == n) {
                return current;
            }
        }
    }

    // If you find the factor until the quare root you can find the rest
    public long countFactors(long n) {
        List<Long> factors = new ArrayList<>();
        // Skip two if the number is odd
        int inc = n % 2 == 0 ? 1 : 2;
        long sqrt = (long) Math.sqrt(n);
        for (long i = 1; i <= sqrt; i+= inc) {
            if (n % i == 0) {
                factors.add(i);
                // Skip duplicates
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }
        return factors.size();
    }
}
