package jalgs;

public class GCD {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr) {
        int gcd = arr[0];
        for (int n : arr) {
            gcd = findGCD(gcd, n);
            if (gcd == 1)
                return 1;
        }
        return gcd;
    }
    public int findGCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return findGCD(y, y % x);
    }
    // METHOD SIGNATURE ENDS
}
