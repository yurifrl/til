package common;

import java.util.*;

// Primes
// To check that a number is prime, from worst to better:
//   Check if any number divide into it
//   Only check if primes divede into it
//   Only if primes up to the square root divide in to it (Sieve of Erastosthenes)
//
// Some prime content -> https://www.youtube.com/watch?v=lEvXcTYqtKU
class Prime {
    // Check if n it's prime by dividing up to half of n
    public static boolean isPrimeByDivisionToTheHalf(long n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // I don't fully undestand this
    // Check if its prime by dividing until the sqrt of n
    public static boolean isPrimeWithSqrt(long n) {
        if (n < 2) {
            return false;
        }

        long sqrt = (long) Math.sqrt(n);

        for(long i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // TODO: Check if it's prime by using the lucas method
    //

    // TODO: Check if it's prime by using the lucas-lehmer method
    // https://en.wikipedia.org/wiki/Lucas%E2%80%93Lehmer_primality_test
    //
    // Determine if Mp = 2p − 1 is prime for p > 2
    // Lucas–Lehmer(p)
    //     var s = 4
    //     var M = 2p − 1
    //     repeat p − 2 times:
    //     s = ((s × s) − 2) mod M
    //         if s == 0 return PRIME else return COMPOSITE
    static boolean isMerseneNumberPrimeByLucasLehmer(int p) {
        if (p == 2) {
            return true;
        }

        // First number of the series
        double s = 4;

        // generate the number
        double m = Math.pow(2, p) - 1;

        // Generate the rest (p-2) terms
        // of the series.
        for (int i = 1; i < p - 1; i++) {
            s = (Math.pow(s, 2) - 2) % m;
        }

        // now if the (p-1)th term is
        // 0 return true else false.
        return s == 0;
    }


    static boolean isPrimeByLucas(int n) {
        int k = 10;
        if (n == 2) {
            return true;
        }
        // If greater then 2 and odd
        if (n > 2 && n % 2 == 0) {
            return false;
        }
        while (k-- != 0) {
            // pick a randomly in the range [2, n − 1]
            int a = 2;
            if ((Math.pow(a, n -1) % n) != 1) {
                return false;
            }
            int sqrt = (int)Math.sqrt(n-1);
            for (int q = 1; q <= sqrt; q++) {
                if ((Math.pow(a, (n-1 / q)) % n ) != 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // TODO: implement isPrime using The Sieve of Erastosthenes
    // This way you compare the factors with only prime numbers
    public static boolean isPrimeByTheSieveOfErastosthenes(long n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        List<Long> primes = new ArrayList<>();
        // boolean primes[] = new boolean[n + 1];
        for(long i=2; i < n; i++) {
            primes.add(i);
        }

        for(long p = 2; p*p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            // Update all multiples of p
            for(long i = p*2; i <= n; i += p) {
                primes.remove(i);
            }
        }

        for(int i = 0; i < primes.size(); i++) {
            if(primes.get(i) % n == 0) {
                return false;
            }
        }

        return true;
    }
}
