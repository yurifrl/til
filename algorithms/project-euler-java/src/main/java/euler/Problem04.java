package euler;

// 04. Find the largest palindrome made from the product of two 3-digit numbers.
// O(n²)
public class Problem04 {
    public long exec (long n1, long n2) {
        long result = 0;
        long largest = 0;
        for (long i = n1; i > 0; i--) {
            for (long j = n2; j > 0; j--) {
                result = i * j;
                if (isPalindrome(result)) {
                    largest = Math.max(largest, result);
                }
            }
        }
        return largest;
    }

    public long reverse(long n) {
        StringBuilder a = new StringBuilder(String.valueOf(n));

        return Long.valueOf(a.reverse().toString());
    }

    public boolean isPalindrome(long n) {
        return reverse(n) == n;
    }
}