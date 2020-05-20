package euler;

// Find the difference between the sum of the squares of the first one hundred natural numbers
// and the square of the sum.
public class Problem06 {
    public long exec(long n) {
        long sumOfTheSquares = 0;
        long sum = 0;
        for (; n > 0; n--) {
            sumOfTheSquares += n * n;
            sum += n;
        }
        return (sum * sum) - sumOfTheSquares;
    }
}
