package util;

// Primes
// To check that a number is prime, from worst to better:
//   Check if any number divide into it
//   Only check if primes divede into it
//   Only if primes up to the square root divide in to it
class Prime {
    // Check if n it's prime by dividing up to half of n
    public static boolean isPrimeByDivisionToTheHalf(long n) {
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

    // TODO:
    // Check n by the prime numbers until the sqrt of n

    // https://www.youtube.com/watch?v=lEvXcTYqtKU
    // TODO: Check if it's prime by using the lucas method
    // TODO: Check if it's prime by using the lucas-lehmer method
    static boolean isPrimeByLucasLehmer(long p) {
        double x = Math.pow(2, p) - 1;
        double y = getLucasLehmerNumberAtPoint(x);
        return x % y == 0;
    }
    public static long getLucasLehmerNumberAtPoint(double n) {
        return lucasHelper(n, 4);
    }
    private static long lucasHelper(double n, double x) {
        if (n == 0) {
            return (long) x;
        }
        return lucasHelper(--n, Math.pow(x, 2) - 2);
    }
}
