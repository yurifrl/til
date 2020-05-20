package euler;

// https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem
public class Problem05 {
    public long exec(long upperBound) {
        for (long needle = 1; true; needle++) {
            if (isDivisibleByRange(needle, upperBound)) {
                return needle;
            }
        }
    }

    public boolean isDivisibleByRange(long testd, long max) {
        for (int y = 1; y < max; y++) {
            if (testd % y != 0) {
                return false;
            }
        }
        return true;
    }
}