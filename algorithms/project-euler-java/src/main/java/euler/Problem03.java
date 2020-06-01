package euler;

import java.util.Set;
import java.util.HashSet;

// 03. What is the largest prime factor of the number 600851475143 ?
// O(n log(n))
// https://medium.com/@adzo261/project-euler-3-b193d741de8f
// https://codereview.stackexchange.com/a/74600
// Largest prime factor
public class Problem03 {
    public long second(long n) {
        Set<Long> factor = factors(n);
        long largest = 0;
        for(long f : factor) {
            int count = 0;
            for(long div = 1; div <= f; div++) {
                if(f % div == 0){
                    count++;
                }
                if(count > 1 && div < f) {
                    break;
                }
                if(div == f) {
                    largest = Math.max(largest, f);
                }
            }
        }
        return largest;
    }
    public Set<Long> factors(long n) {
        Set<Long> factor = new HashSet<>();
        long sqrt = (long)Math.sqrt(n);
        for(long x = 2; x <= sqrt; x++) {
            if(n % x == 0) {
                factor.add(x);
            }
        }
        for(int i = 0; i < factor.size(); i++) {
            factor.add(n / factor.iterator().next());
        }
        factor.add(n);
        return factor;
    }

    public long first(long n) {
        long factor = -1;
        // the upper bound is the square root of the number
        for (long i = 2; i * i <= n; i++) {
            if (n == 1) {
                break;
            }
            if (n % i != 0) {
                continue;
            }
            // for now it's checked that it is prime, not a factor
            factor = i;
            // now for the factor part
            // here we are checking if it's a factor indead
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1 ? factor : n;
    }
}
