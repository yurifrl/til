package euler;

public class Problem09 {
    // There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    // Find the product abc.
    // For example, 3²+ 4²= 9 + 16 = 25 = 52.
    //
    public long exec(int limit) {
        for (int a = 3; a < limit; a++) {
            for (int b = a + 1; b < limit; b++) {
                double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                if ((a + b + c) == limit) {
                    return (long)(a * b * c);
                }
            }
        }
        return -1;
    }
}
