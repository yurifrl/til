package euler;

import java.math.BigInteger;

public class Problem13 {
    public String first(String[] n) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n.length; i++) {
            sum = sum.add(new BigInteger(n[i]));
        }
        String str = sum.toString();
        return str.substring(0, 10);
    }
}
