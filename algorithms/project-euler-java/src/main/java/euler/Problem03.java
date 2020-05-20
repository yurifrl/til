package euler;

// 03. What is the largest prime factor of the number 600851475143 ?
// O(n log(n))
// https://medium.com/@adzo261/project-euler-3-b193d741de8f
// https://codereview.stackexchange.com/a/74600
// Largest prime factor
public class Problem03 {
    public long exec(long n) {
        long factor = -1;
        // the upper bound is the square root of the number
        for (long i = 2; i * i <= n; i++) {
            if (n == 1) { break; }
            if (n % i != 0) { continue; }
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