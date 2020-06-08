package euler;

import java.util.*;

public class Problem12 {
    public long first(long n) {
        long current = 0;
        HashSet<Long> factors;

        for(int i = 1; i < Long.MAX_VALUE;i++) {
            current += i;
            // Check factors count
            factors = countFactors(current);
            if(factors.size() >= n) {
                return current;
            }
        }
        return -1;
    }

    // If you find the factor until the quare root you can find the rest
    public HashSet<Long> countFactors(long n) {
        HashSet<Long> factorsFirstHalf = new HashSet<>();
        HashSet<Long> factorsSecondHalf = new HashSet<>();

        // Skip two if the number is odd
        long sqrt = (long) Math.sqrt(n);
        for (long i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                factorsFirstHalf.add(i);
            }
        }

        Iterator<Long> iterator = factorsFirstHalf.iterator();
        while(iterator.hasNext()) {
            long n1 = iterator.next();
            factorsSecondHalf.add(n / n1);
        }

        factorsFirstHalf.addAll(factorsSecondHalf);

        return factorsFirstHalf;
    }
}
